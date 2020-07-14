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
 * Advanced or structured data tape type
 * 
 * <p>typeType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="typeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="category" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}categoryType"/>
 *         &lt;element name="underSchema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="underType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="instantiable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="final" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="base" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}predefinedTypeType" minOccurs="0"/>
 *         &lt;element name="attributes" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}attributesType" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typeType", namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", propOrder = {
    "name",
    "category",
    "underSchema",
    "underType",
    "instantiable",
    "_final",
    "base",
    "attributes",
    "description"
})
public class TypeType {

    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    protected String name;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    @XmlSchemaType(name = "string")
    protected CategoryType category;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected String underSchema;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected String underType;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected boolean instantiable;
    @XmlElement(name = "final", namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected boolean _final;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected String base;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected AttributesType attributes;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected String description;

    /**
     * name 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * name 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * category 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CategoryType }
     *     
     */
    public CategoryType getCategory() {
        return category;
    }

    /**
     * category 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryType }
     *     
     */
    public void setCategory(CategoryType value) {
        this.category = value;
    }

    /**
     * underSchema 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnderSchema() {
        return underSchema;
    }

    /**
     * underSchema 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnderSchema(String value) {
        this.underSchema = value;
    }

    /**
     * underType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnderType() {
        return underType;
    }

    /**
     * underType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnderType(String value) {
        this.underType = value;
    }

    /**
     * instantiable 속성의 값을 가져옵니다.
     * 
     */
    public boolean isInstantiable() {
        return instantiable;
    }

    /**
     * instantiable 속성의 값을 설정합니다.
     * 
     */
    public void setInstantiable(boolean value) {
        this.instantiable = value;
    }

    /**
     * final 속성의 값을 가져옵니다.
     * 
     */
    public boolean isFinal() {
        return _final;
    }

    /**
     * final 속성의 값을 설정합니다.
     * 
     */
    public void setFinal(boolean value) {
        this._final = value;
    }

    /**
     * base 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBase() {
        return base;
    }

    /**
     * base 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBase(String value) {
        this.base = value;
    }

    /**
     * attributes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AttributesType }
     *     
     */
    public AttributesType getAttributes() {
        return attributes;
    }

    /**
     * attributes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributesType }
     *     
     */
    public void setAttributes(AttributesType value) {
        this.attributes = value;
    }

    /**
     * description 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * description 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
