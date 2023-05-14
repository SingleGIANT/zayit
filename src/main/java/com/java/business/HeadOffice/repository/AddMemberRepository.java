package com.java.business.HeadOffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.business.HeadOffice.entity.AddMember;

public interface AddMemberRepository extends JpaRepository<AddMember, Long> {

//	@Query(value="select m from AddMember m where m.phone=?1")
//	AddMember checkMemberPhone(Long phone);
//	
//	@Query(value = "select m from AddMember m where m.email=?1")
//	AddMember checkMemberByEmail(String email);
//	
//	@Query(value = "select m.status from AddMember m where m.email=?1 and m.password=?2")
//	String getMemberPasswordByEmail(String email);
//	
//	@Modifying(clearAutomatically = true)
//	@Query("update AddMember m set m.password =:password where m.email =:email")
//	boolean findStatusMember(String email, String password);
//	
//	@Modifying(clearAutomatically = true)
//	@Query("update AddMember m set m.password =:password where m.email =:email")
//	void changePassword(@Param("email") String email, @Param("password") String password);
//	
//	@Query(value = "select m.memberid from AddMember m where m.email=?1")
//	Long findMemberId(String memberEmail);

//	
//	@Modifying(clearAutomatically = true)
//	@Query("update AddMember m set m.name =:name,m.address =:address,m.gender = :gender,m.phone =:phone,m.aadharno =:aadharno,m.panno=:panno;m.dob=:dob,m.description=:description where c.id =:memberid")
//	void updateMyMember(@Param("id") Long memberid,@Param("name") String name, @Param("address") String address,@Param("gender") String gender, 
//			@Param("phone") Long phone, @Param("aadharno") Long aadharno, @Param("panno") String panno,
//			@Param("role")String role, @Param("description")String description);


}
	
	
