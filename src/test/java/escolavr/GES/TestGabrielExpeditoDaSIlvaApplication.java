package escolavr.GES;

import org.springframework.boot.SpringApplication;

public class TestGabrielExpeditoDaSIlvaApplication {

	public static void main(String[] args) {
		SpringApplication.from(GabrielExpeditoDaSIlvaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
