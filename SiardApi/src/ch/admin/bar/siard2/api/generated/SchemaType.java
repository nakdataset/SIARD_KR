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
import javax.xml.bind.annotation.XmlType;


/**
 * Schema element in siardArchive
 * 
 * <p>schemaType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="schemaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="folder" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}fsName"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="types" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}typesType" minOccurs="0"/>
 *         &lt;element name="tables" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}tablesType" minOccurs="0"/>
 *         &lt;element name="views" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}viewsType" minOccurs="0"/>
 *         &lt;element name="routines" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}routinesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "schemaType", namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", propOrder = {
    "name",
    "folder",
    "description",
    "types",
    "tables",
    "views",
    "routines"
})
public class SchemaType {

    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    protected String name;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    protected String folder;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected String description;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected TypesType types;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected TablesType tables;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected ViewsType views;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected RoutinesType routines;

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
     * folder 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolder() {
        return folder;
    }

    /**
     * folder 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolder(String value) {
        this.folder = value;
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

    /**
     * types 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TypesType }
     *     
     */
    public TypesType getTypes() {
        return types;
    }

    /**
     * types 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TypesType }
     *     
     */
    public void setTypes(TypesType value) {
        this.types = value;
    }

    /**
     * tables 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TablesType }
     *     
     */
    public TablesType getTables() {
        return tables;
    }

    /**
     * tables 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TablesType }
     *     
     */
    public void setTables(TablesType value) {
        this.tables = value;
    }

    /**
     * views 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ViewsType }
     *     
     */
    public ViewsType getViews() {
        return views;
    }

    /**
     * views 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ViewsType }
     *     
     */
    public void setViews(ViewsType value) {
        this.views = value;
    }

    /**
     * routines 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link RoutinesType }
     *     
     */
    public RoutinesType getRoutines() {
        return routines;
    }

    /**
     * routines 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link RoutinesType }
     *     
     */
    public void setRoutines(RoutinesType value) {
        this.routines = value;
    }

}
