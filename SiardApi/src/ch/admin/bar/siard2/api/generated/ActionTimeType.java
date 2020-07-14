//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2020.07.13 시간 10:36:27 AM KST 
//


package ch.admin.bar.siard2.api.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>actionTimeType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="actionTimeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BEFORE"/>
 *     &lt;enumeration value="INSTEAD OF"/>
 *     &lt;enumeration value="AFTER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "actionTimeType", namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
@XmlEnum
public enum ActionTimeType {

    BEFORE("BEFORE"),
    @XmlEnumValue("INSTEAD OF")
    INSTEAD_OF("INSTEAD OF"),
    AFTER("AFTER");
    private final String value;

    ActionTimeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActionTimeType fromValue(String v) {
        for (ActionTimeType c: ActionTimeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
