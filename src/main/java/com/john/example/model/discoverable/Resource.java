package com.john.example.model.discoverable;

import com.john.example.annotations.Author;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
@XmlRootElement(name = "resource")
@XmlType(name = "resource", propOrder = {"name", "ref", "allowed"})
public class Resource {
    @XmlTransient
    public static final String BASE_URI = "http://localhost:8080/example/api/v1";
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "ref")
    private String ref;
    @XmlElement(name = "allowed")
    private List<String> allowed;

    /**
     * Needed by JAXB
     */
    public Resource(){}

    public Resource (final String name, final String ref, final List<String> allowed) {
        this.name = name;
        this.ref = BASE_URI + ref;
        this.allowed = allowed;
    }

    public String getName() {
        return name;
    }

    public String getRef() {
        return ref;
    }

    public List<String> getAllowed() {
        return allowed;
    }
}
