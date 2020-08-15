package com.quinnox.qtvt.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quinnox.qtvt.bean.QTVTFormBean;
import com.quinnox.qtvt.constants.Constants;
import com.quinnox.qtvt.model.Employee;
import com.quinnox.qtvt.model.QTVTform;

@SuppressWarnings("unused")
@Repository
public interface QTVTFormRepository extends JpaRepository<QTVTform, Long>{

	
	@Transactional
	@Query("Select q from QTVTform q where (q.status="+"'"+Constants.OPEN+"'"+"OR q.status="+"'"+Constants.ONHOLD+"')")
	List<QTVTform> getAllQtvtForm();
	
	
	@Transactional
	@Query("Select qtvtForm from QTVTform qtvtForm where qtvtForm.formId=?1")
	QTVTform findUserByFormId(long formId);


	@Transactional
	@Query("Select q from QTVTform q where q.empId=?1")
	List<QTVTform> findUserForms(Employee empId);
  

    @Transactional
	@Query("Select q from QTVTform q")
    List<QTVTform> getAllForms();
    
    @Transactional
    @Query("select q from QTVTform q where (q.toDate >= ?1 AND q.fromDate <=?2)")
    List<QTVTform> searchBwDates(Date fromDate,Date toDate);


    @Transactional
    @Query("select q from QTVTform q where (q.toDate >= ?1 AND q.fromDate <=?2)")
	List<QTVTform> getByDate(Date fromDate,Date toDate);


    @Transactional
    @Query("select q from QTVTform q where q.status=?1")
    List<QTVTform> getByStatus(String status);


    @Transactional
    @Query("select q from QTVTform q where q.skillClass=?1")
    List<QTVTform> getBySkills(String skillClass);


    @Transactional
    @Query("select q from QTVTform q where ((q.toDate >= ?1 AND q.fromDate <=?2)and (q.status=?3) and (q.skillClass=?4)) ")    
    List<QTVTform> getByAllFilters(Date fromDate, Date toDate, String status, String skills);

    
    @Transactional
    @Query("select q from QTVTform q where ((q.toDate >= ?1 AND q.fromDate <=?2) and q.status=?3) ")
    List<QTVTform> getByDateAndStatus(Date fromDate, Date toDate, String status);


    @Transactional
    @Query("select q from QTVTform q where ((q.toDate >= ?1 AND q.fromDate <=?2) and q.skillClass=?3) ")
    List<QTVTform> getByDateAndSkills(Date fromDate, Date toDate, String skills);


    @Transactional
    @Query("select q from QTVTform q where ((q.skillClass=?2) and (q.status=?1))")
    List<QTVTform> getByStatusAndSkills(String status, String skills);


    @Transactional
    @Query("select q from QTVTform q where (q.status=?2 OR q.status=?3 OR q.status=?4) AND q.toDate<=?1")
List<QTVTform> findAllOfToday(Date today, String onhold, String assigned, String open);
    
   /* @Transactional
    @Query(value = "UPDATE QTVTform\n" + 
    		"SET status = 'lapsed'" + 
    		"WHERE status in('open','onhold','rejected') and to_date>=GETDATE();",nativeQuery=true)
    void changeStatus();*/
    
    @Transactional
    @Query("select distinct e.empDesignation from Employee e ")
    List<String> getDistinctGrades();
    
    @Transactional
    @Query("select distinct e.empLocation from Employee e ")
    List<String> getDistinctLocations();
    
    @Transactional
    @Query("select distinct s.skillClass from SkillClass s")
    List<String> getDistinctSkills();
    
    @Transactional
    @Query("select count(q) from QTVTform q, Employee e where e.empId=q.empId.empId and e.empDesignation=?1 and q.skillClass=?2 and (q.toDate >= ?3 AND q.fromDate <=?4)")
    int getEmpGradeSkillCount(String grade,String skill,Date fromDate,Date toDate);
    
    @Transactional
    @Query("select q from QTVTform q, Employee e where e.empId=q.empId.empId and e.empDesignation= :grade and q.skillClass= :skill and (q.toDate >= :fromDate AND q.fromDate <= :toDate)")
    List<QTVTform> getHoursGradeSkillCount(@Param("grade")String grade, @Param("skill") String skill, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
    
    
    @Transactional
    @Query("select q from QTVTform q, Employee e where e.empId=q.empId.empId and e.empLocation= :location and q.skillClass= :skill and (q.toDate >= :fromDate AND q.fromDate <= :toDate)")
    List<QTVTform> getHoursLocationSkillCount(@Param("location")String location, @Param("skill") String skill, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);



	
	
	
}
