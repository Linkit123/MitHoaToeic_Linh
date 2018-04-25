package vn.MsHoa.command;

import vn.MsHoa.core.dto.UserDTO;
import vn.MsHoa.core.web.command.AbstractCommand;

/**
 * Created by trinhngoclinh on 4/15/2018.
 */
public class UserCommand extends AbstractCommand<UserDTO> {
    private String confirmPassword;
    public  UserCommand(){
        this.pojo = new UserDTO();
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
