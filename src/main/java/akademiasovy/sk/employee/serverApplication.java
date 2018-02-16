package akademiasovy.sk.employee;

import akademiasovy.sk.employee.resources.Employees;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class serverApplication extends Application<serverConfiguration> {

    public static void main(final String[] args) throws Exception {
        new serverApplication().run(args);
    }

    @Override
    public String getName() {
        return "server";
    }

    @Override
    public void initialize(final Bootstrap<serverConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final serverConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(
                new Employees()
        );

    }

}
