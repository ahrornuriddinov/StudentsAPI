package uz.najot.studentcontroller.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groups {

  private int id;
  @NotBlank
  private String name;
  private Date createdDate;
  private boolean isActive;
  @NotNull
  private int classId;


}
