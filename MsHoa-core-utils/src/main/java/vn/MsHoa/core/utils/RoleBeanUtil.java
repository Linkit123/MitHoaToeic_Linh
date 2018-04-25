package vn.MsHoa.core.utils;

import vn.MsHoa.core.dto.RoleDTO;
import vn.MsHoa.core.persistence.entity.RoleEtity;

/**
 * Created by trinhngoclinh on 4/16/2018.
 */
public class RoleBeanUtil {
    public static RoleDTO entitytoDto(RoleEtity entity){
        RoleDTO dto=new RoleDTO();
        dto.setRoleId(entity.getRoleID());
        dto.setName(entity.getName());
        return dto;
    }
    public static RoleEtity dto2Entity(RoleDTO dto){
        RoleEtity entity=new RoleEtity();
        entity.setName(dto.getName());
        entity.setRoleID(dto.getRoleId());
        return entity;
    }
}
