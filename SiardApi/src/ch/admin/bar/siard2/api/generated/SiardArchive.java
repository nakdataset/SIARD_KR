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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Root element of meta data of the SIARD archive
 * 
 * <p>anonymous complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dbname" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}mandatoryString"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="archiver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="archiverContact" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataOwner" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}mandatoryString"/>
 *         &lt;element name="dataOriginTimespan" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}mandatoryString"/>
 *         &lt;element name="lobFolder" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="producerApplication" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="archivalDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="messageDigest" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}messageDigestType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="clientMachine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="databaseProduct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="databaseUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="schemas" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}schemasType"/>
 *         &lt;element name="users" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}usersType"/>
 *         &lt;element name="roles" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}rolesType" minOccurs="0"/>
 *         &lt;element name="privileges" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}privilegesType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" use="required" type="{http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd}versionType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dbname",
    "description",
    "archiver",
    "archiverContact",
    "dataOwner",
    "dataOriginTimespan",
    "lobFolder",
    "producerApplication",
    "archivalDate",
    "messageDigest",
    "clientMachine",
    "databaseProduct",
    "connection",
    "databaseUser",
    "schemas",
    "users",
    "roles",
    "privileges"
})
@XmlRootElement(name = "siardArchive", namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
public class SiardArchive {

    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    protected String dbname;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected String description;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected String archiver;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected String archiverContact;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    protected String dataOwner;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    protected String dataOriginTimespan;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    @XmlSchemaType(name = "anyURI")
    protected String lobFolder;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected String producerApplication;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar archivalDate;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected List<MessageDigestType> messageDigest;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected String clientMachine;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected String databaseProduct;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected String connection;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected String databaseUser;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    protected SchemasType schemas;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd", required = true)
    protected UsersType users;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected RolesType roles;
    @XmlElement(namespace = "http://www.bar.admin.ch/xmlns/siard/2/metadata.xsd")
    protected PrivilegesType privileges;
    @XmlAttribute(name = "version", required = true)
    protected String version;

    /**
     * dbname 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDbname() {
        return dbname;
    }

    /**
     * dbname 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDbname(String value) {
        this.dbname = value;
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
     * archiver 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchiver() {
        return archiver;
    }

    /**
     * archiver 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchiver(String value) {
        this.archiver = value;
    }

    /**
     * archiverContact 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchiverContact() {
        return archiverContact;
    }

    /**
     * archiverContact 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchiverContact(String value) {
        this.archiverContact = value;
    }

    /**
     * dataOwner 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataOwner() {
        return dataOwner;
    }

    /**
     * dataOwner 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataOwner(String value) {
        this.dataOwner = value;
    }

    /**
     * dataOriginTimespan 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataOriginTimespan() {
        return dataOriginTimespan;
    }

    /**
     * dataOriginTimespan 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataOriginTimespan(String value) {
        this.dataOriginTimespan = value;
    }

    /**
     * lobFolder 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLobFolder() {
        return lobFolder;
    }

    /**
     * lobFolder 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLobFolder(String value) {
        this.lobFolder = value;
    }

    /**
     * producerApplication 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerApplication() {
        return producerApplication;
    }

    /**
     * producerApplication 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerApplication(String value) {
        this.producerApplication = value;
    }

    /**
     * archivalDate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArchivalDate() {
        return archivalDate;
    }

    /**
     * archivalDate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArchivalDate(XMLGregorianCalendar value) {
        this.archivalDate = value;
    }

    /**
     * Gets the value of the messageDigest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageDigest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageDigest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessageDigestType }
     * 
     * 
     */
    public List<MessageDigestType> getMessageDigest() {
        if (messageDigest == null) {
            messageDigest = new ArrayList<MessageDigestType>();
        }
        return this.messageDigest;
    }

    /**
     * clientMachine 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientMachine() {
        return clientMachine;
    }

    /**
     * clientMachine 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientMachine(String value) {
        this.clientMachine = value;
    }

    /**
     * databaseProduct 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatabaseProduct() {
        return databaseProduct;
    }

    /**
     * databaseProduct 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatabaseProduct(String value) {
        this.databaseProduct = value;
    }

    /**
     * connection 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnection() {
        return connection;
    }

    /**
     * connection 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnection(String value) {
        this.connection = value;
    }

    /**
     * databaseUser 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatabaseUser() {
        return databaseUser;
    }

    /**
     * databaseUser 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatabaseUser(String value) {
        this.databaseUser = value;
    }

    /**
     * schemas 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SchemasType }
     *     
     */
    public SchemasType getSchemas() {
        return schemas;
    }

    /**
     * schemas 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemasType }
     *     
     */
    public void setSchemas(SchemasType value) {
        this.schemas = value;
    }

    /**
     * users 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link UsersType }
     *     
     */
    public UsersType getUsers() {
        return users;
    }

    /**
     * users 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link UsersType }
     *     
     */
    public void setUsers(UsersType value) {
        this.users = value;
    }

    /**
     * roles 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link RolesType }
     *     
     */
    public RolesType getRoles() {
        return roles;
    }

    /**
     * roles 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link RolesType }
     *     
     */
    public void setRoles(RolesType value) {
        this.roles = value;
    }

    /**
     * privileges 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PrivilegesType }
     *     
     */
    public PrivilegesType getPrivileges() {
        return privileges;
    }

    /**
     * privileges 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivilegesType }
     *     
     */
    public void setPrivileges(PrivilegesType value) {
        this.privileges = value;
    }

    /**
     * version 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * version 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
