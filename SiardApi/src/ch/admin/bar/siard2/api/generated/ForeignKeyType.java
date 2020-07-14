//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2020.07.13 시간 10:36:27 AM KST 
//


package ch.admin.bar.siard2.api.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * foreignKey element in siardArchive
 * 
 * <p>foreignKeyType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="foreignKeyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="referencedSchema" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="referencedTable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reference" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}referenceType" maxOccurs="unbounded"/>
 *         &lt;element name="matchType" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}matchTypeType" minOccurs="0"/>
 *         &lt;element name="deleteAction" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}referentialActionType" minOccurs="0"/>
 *         &lt;element name="updateAction" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}referentialActionType" minOccurs="0"/>
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
@XmlType(name = "foreignKeyType", namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", propOrder = {
    "name",
    "referencedSchema",
    "referencedTable",
    "reference",
    "matchType",
    "deleteAction",
    "updateAction",
    "description"
})
public class ForeignKeyType {

    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    protected String name;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    protected String referencedSchema;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    protected String referencedTable;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    protected List<ReferenceType> reference;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    @XmlSchemaType(name = "string")
    protected MatchTypeType matchType;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    @XmlSchemaType(name = "string")
    protected ReferentialActionType deleteAction;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    @XmlSchemaType(name = "string")
    protected ReferentialActionType updateAction;
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
     * referencedSchema 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencedSchema() {
        return referencedSchema;
    }

    /**
     * referencedSchema 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencedSchema(String value) {
        this.referencedSchema = value;
    }

    /**
     * referencedTable 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencedTable() {
        return referencedTable;
    }

    /**
     * referencedTable 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencedTable(String value) {
        this.referencedTable = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     * 
     * 
     */
    public List<ReferenceType> getReference() {
        if (reference == null) {
            reference = new ArrayList<ReferenceType>();
        }
        return this.reference;
    }

    /**
     * matchType 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link MatchTypeType }
     *     
     */
    public MatchTypeType getMatchType() {
        return matchType;
    }

    /**
     * matchType 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link MatchTypeType }
     *     
     */
    public void setMatchType(MatchTypeType value) {
        this.matchType = value;
    }

    /**
     * deleteAction 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ReferentialActionType }
     *     
     */
    public ReferentialActionType getDeleteAction() {
        return deleteAction;
    }

    /**
     * deleteAction 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferentialActionType }
     *     
     */
    public void setDeleteAction(ReferentialActionType value) {
        this.deleteAction = value;
    }

    /**
     * updateAction 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ReferentialActionType }
     *     
     */
    public ReferentialActionType getUpdateAction() {
        return updateAction;
    }

    /**
     * updateAction 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferentialActionType }
     *     
     */
    public void setUpdateAction(ReferentialActionType value) {
        this.updateAction = value;
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
