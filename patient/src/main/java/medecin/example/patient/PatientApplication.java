package medecin.example.patient;

import medecin.example.patient.entities.*;
import medecin.example.patient.repositories.ConsultationRepository;
import medecin.example.patient.repositories.MedecinRepository;
import medecin.example.patient.repositories.PatientRepository;
import medecin.example.patient.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
	}
	@Bean
	CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository){
		return args -> {
			Stream.of("Mohamed", "Ayoub", "Amin")
					.forEach(name -> {
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDatenaissance(new Date());
						patient.setMalade(false);
						patientRepository.save(patient);
					}

					);
			Stream.of("anas", "rachid", "rabii")
					.forEach(name -> {
								Medecin medecin = new Medecin();
								medecin.setNom(name);
								medecin.setSpecialite(Math.random()>0.5 ? "generatliste": "cardio");
								medecin.setEmail(name + "@gmail.com");
								medecinRepository.save(medecin);
							}

					);
			Stream.of("karim", "ayman")
					.forEach(name -> {
						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setSpecialite(Math.random()>0.5? "Dermato": "podologue");
						medecin.setEmail(name+ "@hotmail.com");
						medecinRepository.save(medecin);
					});
			//Medecin medecin = medecinRepository.findByNom("ayman");
			//Patient patient = patientRepository.findByNom("Mohamed");
		//	Patient patient1 = patientRepository.findById(1L).orElse(null);
		//	RendezVous rendezVous = new RendezVous();
		//	rendezVous.setDate(new Date());
		//	rendezVous.setPatient(patient1);
		//	rendezVous.setStatus(StatusRDV.PENDING);
		//	rendezVous.setMedecin(medecin);
		//	rendezVousRepository.save(rendezVous);
		//	Consultation consultation = new Consultation();
		//	consultation.setRendezVous(rendezVous);
		//	consultation.setDateConsultation(new Date());
		//	consultationRepository.save(consultation);



		};

	}

}
