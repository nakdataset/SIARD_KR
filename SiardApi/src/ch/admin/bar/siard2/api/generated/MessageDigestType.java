//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2020.07.13 시간 10:36:27 AM KST 
//


package ch.admin.bar.siard2.api.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Message digests with algorithm ("MD5", "SHA-1" or "SHA-256") and hexadecimal or - for the SHA variants - Base64 code.
 * 
 * <p>messageDigestType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="messageDigestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="digestType" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}digestTypeType"/>
 *         &lt;element name="digest" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageDigestType", namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", propOrder = {
    "digestType",
    "digest"
})
public class MessageDigestType {

    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    @XmlSchemaType(name = "string")
    protected DigestTypeType digestType;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    protected String digest;

    /**
     * digestType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link DigestTypeType }
     *     
     */
    public DigestTypeType getDigestType() {
        return digestType;
    }

    /**
     * digestType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link DigestTypeType }
     *     
     */
    public void setDigestType(DigestTypeType value) {
        this.digestType = value;
    }

    /**
     * digest 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDigest() {
        return digest;
    }

    /**
     * digest 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDigest(String value) {
        this.digest = value;
    }

}
