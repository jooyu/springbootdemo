package com.zy.test.domain;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "collection")
@XmlAccessorType(XmlAccessType.NONE)
public class CollectionOfElements {

	@XmlElements(@XmlElement(name = "message", type = Message.class))
	private Collection<?> elements;

	protected CollectionOfElements() {

	}

	public CollectionOfElements(Collection<?> elements) {
		super();
		this.elements = elements;
	}

	public Collection<?> getElements() {
		return elements;
	}
}
