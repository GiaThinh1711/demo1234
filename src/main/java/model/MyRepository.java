//package model;
//
//import annotation.Column;
//import annotation.Table;
//
//import java.lang.reflect.Field;
//
//public class MyRepository<T> {
//    public boolean save(T obj) {
//        String tableName = "";
//        Class clazz = obj.getClass();
//        if (!clazz.isAnnotationPresent(Table.class)) {
//            return false;
//        }
//        Table table = (Table) clazz.getDeclaredAnnotation(Table.class);
//        if (table.name() != null && table.name().length() > 0) {
//            tableName = table.name();
//        } else {
//            tableName = clazz.getSimpleName() + "s";
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("INSERT INTO");
//        stringBuilder.append("");
//        stringBuilder.append(tableName);
//
//        StringBuilder fieldNameBuilder = new StringBuilder();
//        fieldNameBuilder.append("(");
//        Field[] fields = clazz.getDeclaredFields();
//        for (Field field : fields) {
//            if (!field.isAnnotationPresent(Column.class)) {
//                continue;
//            }
//            Column column = field.getDeclaredAnnotation(Column.class);
//            fieldNameBuilder.append(column.name());
//            fieldNameBuilder.append(",");
//            fieldNameBuilder.setLength(fieldNameBuilder.length() - 2);
//            fieldNameBuilder.append("");
//            stringBuilder.append(fieldNameBuilder);
//            stringBuilder.append("");
//            stringBuilder.append("VALUES");
//            stringBuilder.append("");
//
//            StringBuilder fieldValueBuilder = new StringBuilder();
//            fieldValueBuilder.append("(");
//
//            }
//        }
//    }
//}
