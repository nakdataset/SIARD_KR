//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2020.07.13 시간 10:36:28 AM KST 
//


package ch.admin.bar.siard2.api.generated.old10;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>matchTypeType에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * <p>
 * <pre>
 * &lt;simpleType name="matchTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FULL"/>
 *     &lt;enumeration value="PARTIAL"/>
 *     &lt;enumeration value="SIMPLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "matchTypeType", namespace = "http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd")
@XmlEnum
public enum MatchTypeType {

    FULL,
    PARTIAL,
    SIMPLE;

    public String value() {
        return name();
    }

    public static MatchTypeType fromValue(String v) {
        return valueOf(v);
    }

}
