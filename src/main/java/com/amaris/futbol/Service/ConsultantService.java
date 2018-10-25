package com.amaris.futbol.Service;

import com.amaris.futbol.domain.Consultant;
import com.amaris.futbol.repository.ConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ConsultantService extends GenericServiceImple<Consultant> {

    @Autowired
    ConsultantRepository consultantRepository;

}
