package uz.najot.studentcontroller.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

  private int id;
  private String name;
  private String tag;
  private Date createdDate;
  private int classId;
  private boolean isActive;



}
