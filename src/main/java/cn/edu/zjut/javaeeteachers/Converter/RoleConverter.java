package cn.edu.zjut.javaeeteachers.Converter;

import cn.edu.zjut.javaeeteachers.model.Role;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role role) {
        return role != null ? role.name() : null; // 存储大写值
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        return dbData != null ? Role.fromString(dbData) : null; // 从数据库值转换为枚举
    }
}