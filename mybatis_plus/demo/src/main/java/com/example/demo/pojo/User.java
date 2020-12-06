package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableLogic //逻辑删除
    private Integer deleted;
    @Version//乐观锁
    private Integer version;
    @TableField(fill = FieldFill.INSERT)
    private Date creatTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
