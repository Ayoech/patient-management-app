package medecin.example.patient.web;


import lombok.AllArgsConstructor;
import medecin.example.patient.entities.Patient;
import medecin.example.patient.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping(path="/index")
    public String patients(Model model, @RequestParam(name="page", defaultValue = "0") int page,@RequestParam(name="size", defaultValue = "5") int size, @RequestParam(name = "Keyword", defaultValue="") String Keyword){
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(page, size));
        Page<Patient> patients1 = patientRepository.findByNomContains(Keyword,PageRequest.of(page,size));
        model.addAttribute("listePatients", patients1.getContent());
        model.addAttribute("pages", new int[patients1.getTotalPages()]);
        model.addAttribute("keyword", Keyword);
        model.addAttribute("currentPage", page);
        return "patients";
    }



}
