package chronodb.chrono.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chronodb.chrono.models.SystemSetting;

public interface SystemSettingRepo extends JpaRepository<SystemSetting,String>{

}
