package apitests;

import api.pojoClasses.MainPojo;
import api.pojoClasses.RegisterPojo;
import api.pojoClasses.SuccessRegisterPojo;
import api.pojoClasses.UserDataPojo;

public class BaseTestAPI {

    public MainPojo mainPojo = new MainPojo();
    public UserDataPojo userDataPojo = new UserDataPojo();
    public RegisterPojo register = new RegisterPojo();
    public SuccessRegisterPojo successRegisterPojo = new SuccessRegisterPojo();

}