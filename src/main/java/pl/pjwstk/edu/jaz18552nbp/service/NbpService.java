package pl.pjwstk.edu.jaz18552nbp.service;

import org.springframework.stereotype.Service;
import pl.pjwstk.edu.jaz18552nbp.model.Result;
import pl.pjwstk.edu.jaz18552nbp.repository.NbpRepository;
import pl.pjwstk.edu.jaz18552nbp.webclient.NbpClient;

@Service
public class NbpService {
    private final NbpClient nbpClient;
    private final NbpRepository nbpRepository;

    public NbpService(NbpClient nbpClient, NbpRepository nbpRepository) {
        this.nbpClient = nbpClient;
        this.nbpRepository = nbpRepository;
    }
    public Result getGoldByProvidedData(
            String startDate,
            String enDate) {
        return nbpRepository.save(nbpClient.getResult(startDate,enDate));
    }


}
