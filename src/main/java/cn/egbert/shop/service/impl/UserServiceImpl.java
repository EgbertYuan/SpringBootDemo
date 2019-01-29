package cn.egbert.shop.service.impl;

import cn.egbert.shop.dao.UserDoMapper;
import cn.egbert.shop.dao.UserPasswordDoMapper;
import cn.egbert.shop.dataobject.UserDo;
import cn.egbert.shop.dataobject.UserPasswordDo;
import cn.egbert.shop.error.BusinessException;
import cn.egbert.shop.error.EmBussinessError;
import cn.egbert.shop.service.UserService;
import cn.egbert.shop.service.mode.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDoMapper userDoMapper;
    @Autowired
    private UserPasswordDoMapper passwordDoMapper;

    @Override
    public UserModel getUserById(int id) {
        //调用userdomapper获取到对应的用户dataobject
        UserDo userDo = userDoMapper.selectByPrimaryKey(id);
        UserPasswordDo passwordDo = null;
        if (userDo != null) {
            passwordDo = passwordDoMapper.selectByUserId(userDo.getId());
        }

        return do2Model(userDo, passwordDo);
    }

    @Override
    @Transactional
    public void register(UserModel model) throws BusinessException {
        if (model == null) {
            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR);
        }
        if (StringUtils.isEmpty(model.getName()) || StringUtils.isEmpty(model.getMobile())) {
            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR);
        }
        UserDo userDo = convertUserDoFromModel(model);
        try {
            userDoMapper.insertSelective(userDo);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR, "该手机号已被使用");
        }
        model.setId(userDo.getId());
        UserPasswordDo userPasswordDo = convertUserPasswordFromModel(model);
        passwordDoMapper.insertSelective(userPasswordDo);
    }

    /**
     * 实现model->dataobject方法
     *
     * @param model
     * @return
     */
    public UserDo convertUserDoFromModel(UserModel model) {
        if (model == null) {
            return null;
        }
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(model, userDo);
        return userDo;
    }

    /**
     * 实现model->dataobject方法
     *
     * @param model
     * @return
     */
    public UserPasswordDo convertUserPasswordFromModel(UserModel model) {
        if (model == null) {
            return null;
        }
        UserPasswordDo userPasswordDo = new UserPasswordDo();
        userPasswordDo.setEncrptPassword(model.getPassword());
        userPasswordDo.setUserId(model.getId());
        return userPasswordDo;
    }

    public UserModel do2Model(UserDo userDo, UserPasswordDo passwordDo) {
        if (userDo == null || passwordDo == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDo, userModel);
        userModel.setPassword(passwordDo.getEncrptPassword());
        return userModel;
    }
}
