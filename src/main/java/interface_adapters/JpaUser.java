package interface_adapters;


import use_case_layer.UserDsRequestModel;
import use_case_layer.UserRegisterDsGateway;

public class JpaUser implements UserRegisterDsGateway {

    final JpaUserRepository repository;

    JpaUser(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsById(name);
    }

    @Override
    public void save(UserDsRequestModel requestModel) {
        UserDataMapper accountDataMapper = new UserDataMapper(requestModel.getName(), requestModel.getPassword(), requestModel.getCreationTime());
        repository.save(accountDataMapper);
    }
}