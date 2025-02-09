package cn.com.hanbinit.system.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Schema(name = "用户实体")
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "seq_user", allocationSize = 1, initialValue = 10000)
    private Long id;
    @Schema(name = "昵称")
    private String nickname;
    @Schema(name = "用户名")
    private String username;
    @Schema(name = "密码")
    private String password;
    @Column(length = 1024)
    @Schema(name = "备注")
    private String remark;
}
