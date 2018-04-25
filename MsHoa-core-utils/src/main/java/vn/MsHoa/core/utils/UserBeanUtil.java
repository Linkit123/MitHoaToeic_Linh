package vn.MsHoa.core.utils;

import vn.MsHoa.core.dto.UserDTO;
import vn.MsHoa.core.persistence.entity.RoleEtity;
import vn.MsHoa.core.persistence.entity.UserEntity;

/**
 * Created by trinhngoclinh on 4/16/2018.
 */
public class UserBeanUtil {
    public static UserDTO entitytoDto(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setUserId(entity.getUserId());
        dto.setName(entity.getName());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setFullName(entity.getFullName());
        dto.setPassword(entity.getPassword());
        dto.setRoleDTO(RoleBeanUtil.entitytoDto(entity.getRoleEtity()));
        return dto;
    }
    public static UserEntity dto2Entity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setUserId(dto.getUserId());
        entity.setName(dto.getName());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setFullName(dto.getFullName());
        entity.setPassword(dto.getPassword());
        entity.setRoleEtity(RoleBeanUtil.dto2Entity(dto.getRoleDTO()));
        return entity;
    }
}
