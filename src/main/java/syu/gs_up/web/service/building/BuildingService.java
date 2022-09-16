package syu.gs_up.web.service.building;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import syu.gs_up.web.domain.college.Building;
import syu.gs_up.web.dto.building.BuildingDto;
import syu.gs_up.web.repository.BuildingRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuildingService {

    private final BuildingRepository buildingRepository;


    public String getBuildingName(Long id) {
        Optional<Building> result = buildingRepository.findById(id);
        return result.get().getName();
    }
    public List<BuildingDto> getAllBuildingDtos() {
        List<Building> allBuildings = buildingRepository.findAll();
        return allBuildings.stream()
                .map(b -> new BuildingDto(
                        b.getBuildingId(),
                        b.getName(),
                        b.getIntro(),
                        b.getLatitude(),
                        b.getLongitude()))
                .collect(Collectors.toList());
    }
}
