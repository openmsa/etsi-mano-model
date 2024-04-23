package com.ubiqube.etsi.mano.v451.model.nfvmanologm2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.Link;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Links for this resource.
 */
@Schema(description = "Links for this resource.")
@Validated

public class LoggingJobLinks {
	@JsonProperty("self")
	private Link self = null;

	@JsonProperty("objects")
	@Valid
	private List<Link> objects = null;

	public LoggingJobLinks self(final Link self) {
		this.self = self;
		return this;
	}

	/**
	 * Get self
	 *
	 * @return self
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public Link getSelf() {
		return self;
	}

	public void setSelf(final Link self) {
		this.self = self;
	}

	public LoggingJobLinks objects(final List<Link> objects) {
		this.objects = objects;
		return this;
	}

	public LoggingJobLinks addObjectsItem(final Link objectsItem) {
		if (this.objects == null) {
			this.objects = new ArrayList<>();
		}
		this.objects.add(objectsItem);
		return this;
	}

	/**
	 * Links to resources representing the object instances that are logged. Shall
	 * be present if the logged object instance information is accessible as a
	 * resource.
	 *
	 * @return objects
	 **/
	@Schema(description = "Links to resources representing the object instances that are logged. Shall be present if the logged object instance information is accessible as a resource.")
	@Valid
	public List<Link> getObjects() {
		return objects;
	}

	public void setObjects(final List<Link> objects) {
		this.objects = objects;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final LoggingJobLinks loggingJobLinks = (LoggingJobLinks) o;
		return Objects.equals(this.self, loggingJobLinks.self) &&
				Objects.equals(this.objects, loggingJobLinks.objects);
	}

	@Override
	public int hashCode() {
		return Objects.hash(self, objects);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LoggingJobLinks {\n");

		sb.append("    self: ").append(toIndentedString(self)).append("\n");
		sb.append("    objects: ").append(toIndentedString(objects)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(final java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
