package syu.gs_up.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syu.gs_up.web.domain.college.Building;

public interface BuildingRepository extends JpaRepository<Building,Long> {
}
