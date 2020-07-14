//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2020.07.13 시간 10:36:28 AM KST 
//


package ch.admin.bar.siard2.api.generated.old10;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         Table element in siardArchive
 *       
 * 
 * <p>tableType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="tableType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="folder" type="{http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd}fsName"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="columns" type="{http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd}columnsType"/>
 *         &lt;element name="primaryKey" type="{http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd}primaryKeyType" minOccurs="0"/>
 *         &lt;element name="foreignKeys" type="{http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd}foreignKeysType" minOccurs="0"/>
 *         &lt;element name="candidateKeys" type="{http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd}candidateKeysType" minOccurs="0"/>
 *         &lt;element name="checkConstraints" type="{http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd}checkConstraintsType" minOccurs="0"/>
 *         &lt;element name="triggers" type="{http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd}triggersType" minOccurs="0"/>
 *         &lt;element name="rows" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tableType", namespace = "http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd", propOrder = {
    "name",
    "folder",
    "description",
    "columns",
    "primaryKey",
    "foreignKeys",
    "candidateKeys",
    "checkConstraints",
    "triggers",
    "rows"
})
public class TableType {

    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd", required = true)
    protected String name;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd", required = true)
    protected String folder;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd")
    protected String description;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd", required = true)
    protected ColumnsType columns;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd")
    protected PrimaryKeyType primaryKey;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd")
    protected ForeignKeysType foreignKeys;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd")
    protected CandidateKeysType candidateKeys;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd")
    protected CheckConstraintsType checkConstraints;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd")
    protected TriggersType triggers;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/1.0/metadata.xsd", required = true)
    protected BigInteger rows;

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
     * columns 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ColumnsType }
     *     
     */
    public ColumnsType getColumns() {
        return columns;
    }

    /**
     * columns 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnsType }
     *     
     */
    public void setColumns(ColumnsType value) {
        this.columns = value;
    }

    /**
     * primaryKey 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PrimaryKeyType }
     *     
     */
    public PrimaryKeyType getPrimaryKey() {
        return primaryKey;
    }

    /**
     * primaryKey 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimaryKeyType }
     *     
     */
    public void setPrimaryKey(PrimaryKeyType value) {
        this.primaryKey = value;
    }

    /**
     * foreignKeys 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ForeignKeysType }
     *     
     */
    public ForeignKeysType getForeignKeys() {
        return foreignKeys;
    }

    /**
     * foreignKeys 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ForeignKeysType }
     *     
     */
    public void setForeignKeys(ForeignKeysType value) {
        this.foreignKeys = value;
    }

    /**
     * candidateKeys 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CandidateKeysType }
     *     
     */
    public CandidateKeysType getCandidateKeys() {
        return candidateKeys;
    }

    /**
     * candidateKeys 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CandidateKeysType }
     *     
     */
    public void setCandidateKeys(CandidateKeysType value) {
        this.candidateKeys = value;
    }

    /**
     * checkConstraints 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link CheckConstraintsType }
     *     
     */
    public CheckConstraintsType getCheckConstraints() {
        return checkConstraints;
    }

    /**
     * checkConstraints 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckConstraintsType }
     *     
     */
    public void setCheckConstraints(CheckConstraintsType value) {
        this.checkConstraints = value;
    }

    /**
     * triggers 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link TriggersType }
     *     
     */
    public TriggersType getTriggers() {
        return triggers;
    }

    /**
     * triggers 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link TriggersType }
     *     
     */
    public void setTriggers(TriggersType value) {
        this.triggers = value;
    }

    /**
     * rows 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRows() {
        return rows;
    }

    /**
     * rows 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRows(BigInteger value) {
        this.rows = value;
    }

}
