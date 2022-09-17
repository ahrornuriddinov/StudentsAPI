package uz.najot.studentcontroller.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classes {
  @Min(0)
  private int id;
  @NotBlank@NotNull
  private String name;
  private Date createdDate;
  private boolean isActive;

  public Classes(String name) {
    this.name = name;
  }

  public Classes(int id) {
    this.id = id;
  }
}
