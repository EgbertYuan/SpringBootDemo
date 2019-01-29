package cn.egbert.shop.controller;

import cn.egbert.shop.controller.viewobject.UserVO;
import cn.egbert.shop.error.BusinessException;
import cn.egbert.shop.error.EmBussinessError;
import cn.egbert.shop.response.CommonReturnType;
import cn.egbert.shop.service.UserService;
import cn.egbert.shop.service.mode.UserModel;
import com.alibaba.druid.util.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


@Controller("user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class UserController extends BaseController {
    @Autowired
    UserService userService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        //调用servicef服务获取对应的id用户对象，并且返回给前端
        UserModel model = userService.getUserById(id);
        if (model == null) {
//            model.setPassword("dfa");
            throw new BusinessException(EmBussinessError.USER_NOT_EXIST);
        }
        UserVO userVO = model2VO(model);
        return CommonReturnType.create(userVO);
    }

    /**
     * 用于业务处理的领域模型，转换成前端需要的模型
     *
     * @param model
     * @return
     */
    public UserVO model2VO(UserModel model) {
        if (model == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(model, userVO);
        return userVO;
    }

    //
    @RequestMapping(value = "/getotp")
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name = "mobile") String mobile) {
        //生成验证码
        Random random = new Random();
        int value = random.nextInt(999999);
        String code = String.valueOf(value);
        //把验证码与用户手机号关联,使用httpsession的方式，绑定(后续可以radis)
        httpServletRequest.getSession().setAttribute(mobile, code);
        // 将验证码发送给用户
        System.out.println("mobile=" + mobile + "  &code=" + code);
        return CommonReturnType.create();
    }

    /**
     * @param mobile
     * @param name
     * @return
     */
    @RequestMapping(value = "/register", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType register(@RequestParam(name = "mobile") String mobile,
                                     @RequestParam(name = "name") String name,
                                     @RequestParam(name = "password") String password,
                                     @RequestParam(name = "otp") String otp) throws BusinessException {
        String inSessionOtp = (String) this.httpServletRequest.getSession().getAttribute(mobile);
        if (!StringUtils.equals(inSessionOtp, otp)) {
            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR, "短信验证码不符合 ");
        }
        UserModel model = new UserModel();
        model.setMobile(mobile);
        model.setName(name);
        model.setAge(10);
        model.setPassword(encodeByMD5(password));
        model.setThirdPartyId(1);
        model.setRegisterMode(1);
        userService.register(model);
        return CommonReturnType.create();
    }

    public String encodeByMD5(String string) {
        String encode = "";
        try {
//            确定计算方法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
//            加密字符串
            encode = base64Encoder.encode(md5.digest(string.getBytes("utf-8")));

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encode;
    }
}
