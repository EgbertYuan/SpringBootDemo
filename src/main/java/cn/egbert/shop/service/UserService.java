package cn.egbert.shop.service;

import cn.egbert.shop.error.BusinessException;
import cn.egbert.shop.service.mode.UserModel;

public interface UserService {
    //通过id，获取用户
    UserModel getUserById(int id);

    void register(UserModel model) throws BusinessException;
}
