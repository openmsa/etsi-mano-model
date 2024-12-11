/**
 *     Copyright (C) 2019-2024 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.v331.model.vnfm.grant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v331.model.em.vnflcm.ExtManagedVirtualLinkData;
import com.ubiqube.etsi.mano.v331.model.em.vnflcm.ExtVirtualLinkData;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents a grant.
 */
@Schema(description = "This type represents a grant. ")
@Validated

public class Grant {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("vnfInstanceId")
	private String vnfInstanceId = null;

	@JsonProperty("vnfLcmOpOccId")
	private String vnfLcmOpOccId = null;

	@JsonProperty("vimConnectionInfo")
	@Valid
	private Map<String, VimConnectionInfo> vimConnectionInfo = null;

	@JsonProperty("zones")
	@Valid
	private List<ZoneInfo> zones = null;

	@JsonProperty("zoneGroups")
	@Valid
	private List<ZoneGroupInfo> zoneGroups = null;

	@JsonProperty("addResources")
	@Valid
	private List<GrantInfo> addResources = null;

	@JsonProperty("tempResources")
	@Valid
	private List<GrantInfo> tempResources = null;

	@JsonProperty("removeResources")
	@Valid
	private List<GrantInfo> removeResources = null;

	@JsonProperty("updateResources")
	@Valid
	private List<GrantInfo> updateResources = null;

	@JsonProperty("vimAssets")
	private GrantVimAssets vimAssets = null;

	@JsonProperty("extVirtualLinks")
	@Valid
	private List<ExtVirtualLinkData> extVirtualLinks = null;

	@JsonProperty("extManagedVirtualLinks")
	@Valid
	private List<ExtManagedVirtualLinkData> extManagedVirtualLinks = null;

	@JsonProperty("additionalParams")
	private Map<String, String> additionalParams = null;

	@JsonProperty("_links")
	private GrantLinks links = new GrantLinks();

	public Grant id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 *
	 * @return id
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public Grant vnfInstanceId(final String vnfInstanceId) {
		this.vnfInstanceId = vnfInstanceId;
		return this;
	}

	/**
	 * Get vnfInstanceId
	 *
	 * @return vnfInstanceId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	public void setVnfInstanceId(final String vnfInstanceId) {
		this.vnfInstanceId = vnfInstanceId;
	}

	public Grant vnfLcmOpOccId(final String vnfLcmOpOccId) {
		this.vnfLcmOpOccId = vnfLcmOpOccId;
		return this;
	}

	/**
	 * Get vnfLcmOpOccId
	 *
	 * @return vnfLcmOpOccId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getVnfLcmOpOccId() {
		return vnfLcmOpOccId;
	}

	public void setVnfLcmOpOccId(final String vnfLcmOpOccId) {
		this.vnfLcmOpOccId = vnfLcmOpOccId;
	}

	public Grant vimConnectionInfo(final Map<String, VimConnectionInfo> vimConnectionInfo) {
		this.vimConnectionInfo = vimConnectionInfo;
		return this;
	}

	public Grant putVimConnectionInfoItem(final String key, final VimConnectionInfo vimConnectionInfoItem) {
		if (this.vimConnectionInfo == null) {
			this.vimConnectionInfo = new HashMap<>();
		}
		this.vimConnectionInfo.put(key, vimConnectionInfoItem);
		return this;
	}

	/**
	 * Provides information regarding VIM connections that are approved to be used
	 * by the VNFM to allocate resources, and provides parameters of these VIM
	 * connections. The VNFM shall update the \" vimConnectionInfo\" attribute of
	 * the \"VnfInstance\" structure by adding unknown entries received in this
	 * attribute. This attribute is not intended for the modification of
	 * vimConnectionInfo entries passed earlier; for that, the
	 * VnfInfoModificationRequest structure shall be used. This attribute shall only
	 * be supported when VNF-related Resource Management in direct mode is
	 * applicable. In direct mode, this parameter shall be absent if the VIM
	 * information was configured to the VNFM in another way, present otherwise.
	 * This interface allows to signal the use of multiple VIMs per VNF. However,
	 * due to the partial support of this feature in the present release, it is
	 * recommended in the present document that the number of entries in the
	 * \"vims\" attribute in the Grant is not greater than 1.
	 *
	 * @return vimConnectionInfo
	 **/
	@Schema(description = "Provides information regarding VIM connections that are approved to be used by the VNFM to allocate resources, and provides parameters of these VIM connections. The VNFM shall update the \" vimConnectionInfo\" attribute of the \"VnfInstance\" structure by adding unknown entries received in this attribute. This attribute is not intended for the modification of vimConnectionInfo entries passed earlier; for that, the VnfInfoModificationRequest structure shall be used. This attribute shall only be supported when VNF-related Resource Management in direct mode is applicable. In direct mode, this parameter shall be absent if the VIM information was configured to the VNFM in another way, present otherwise. This interface allows to signal the use of multiple VIMs per VNF. However, due to the partial support of this feature in the present release, it is recommended in the present document that the number of entries in the \"vims\" attribute in the Grant is not greater than 1. ")
	@Valid
	public Map<String, VimConnectionInfo> getVimConnectionInfo() {
		return vimConnectionInfo;
	}

	public void setVimConnectionInfo(final Map<String, VimConnectionInfo> vimConnectionInfo) {
		this.vimConnectionInfo = vimConnectionInfo;
	}

	public Grant zones(final List<ZoneInfo> zones) {
		this.zones = zones;
		return this;
	}

	public Grant addZonesItem(final ZoneInfo zonesItem) {
		if (this.zones == null) {
			this.zones = new ArrayList<>();
		}
		this.zones.add(zonesItem);
		return this;
	}

	/**
	 * Identifies resource zones where the resources are approved to be allocated by
	 * the VNFM.
	 *
	 * @return zones
	 **/
	@Schema(description = "Identifies resource zones where the resources are approved to be allocated by the VNFM. ")
	@Valid
	public List<ZoneInfo> getZones() {
		return zones;
	}

	public void setZones(final List<ZoneInfo> zones) {
		this.zones = zones;
	}

	public Grant zoneGroups(final List<ZoneGroupInfo> zoneGroups) {
		this.zoneGroups = zoneGroups;
		return this;
	}

	public Grant addZoneGroupsItem(final ZoneGroupInfo zoneGroupsItem) {
		if (this.zoneGroups == null) {
			this.zoneGroups = new ArrayList<>();
		}
		this.zoneGroups.add(zoneGroupsItem);
		return this;
	}

	/**
	 * Information about groups of resource zones that are related and that the NFVO
	 * has chosen to fulfil a zoneGroup constraint in the GrantVnfLifecycleOperation
	 * request. This information confirms that the NFVO has honoured the zoneGroup
	 * constraints that were passed as part of \"placementConstraints\" in the
	 * GrantRequest.
	 *
	 * @return zoneGroups
	 **/
	@Schema(description = "Information about groups of resource zones that are related and that the NFVO has chosen to fulfil a zoneGroup constraint in the GrantVnfLifecycleOperation request. This information confirms that the NFVO has honoured the zoneGroup constraints that were passed as part of \"placementConstraints\" in the GrantRequest. ")
	@Valid
	public List<ZoneGroupInfo> getZoneGroups() {
		return zoneGroups;
	}

	public void setZoneGroups(final List<ZoneGroupInfo> zoneGroups) {
		this.zoneGroups = zoneGroups;
	}

	public Grant addResources(final List<GrantInfo> addResources) {
		this.addResources = addResources;
		return this;
	}

	public Grant addAddResourcesItem(final GrantInfo addResourcesItem) {
		if (this.addResources == null) {
			this.addResources = new ArrayList<>();
		}
		this.addResources.add(addResourcesItem);
		return this;
	}

	/**
	 * List of resources that are approved to be added, with one entry per resource.
	 * Shall be set when resources are approved to be added.
	 *
	 * @return addResources
	 **/
	@Schema(description = "List of resources that are approved to be added, with one entry per resource. Shall be set when resources are approved to be added. ")
	@Valid
	public List<GrantInfo> getAddResources() {
		return addResources;
	}

	public void setAddResources(final List<GrantInfo> addResources) {
		this.addResources = addResources;
	}

	public Grant tempResources(final List<GrantInfo> tempResources) {
		this.tempResources = tempResources;
		return this;
	}

	public Grant addTempResourcesItem(final GrantInfo tempResourcesItem) {
		if (this.tempResources == null) {
			this.tempResources = new ArrayList<>();
		}
		this.tempResources.add(tempResourcesItem);
		return this;
	}

	/**
	 * List of resources that are approved to be temporarily instantiated during the
	 * runtime of the lifecycle operation, with one entry per resource. Shall be set
	 * when resources are approved to be temporarily instantiated.
	 *
	 * @return tempResources
	 **/
	@Schema(description = "List of resources that are approved to be temporarily instantiated during the runtime of the lifecycle operation, with one entry per resource. Shall be set when resources are approved to be temporarily  instantiated. ")
	@Valid
	public List<GrantInfo> getTempResources() {
		return tempResources;
	}

	public void setTempResources(final List<GrantInfo> tempResources) {
		this.tempResources = tempResources;
	}

	public Grant removeResources(final List<GrantInfo> removeResources) {
		this.removeResources = removeResources;
		return this;
	}

	public Grant addRemoveResourcesItem(final GrantInfo removeResourcesItem) {
		if (this.removeResources == null) {
			this.removeResources = new ArrayList<>();
		}
		this.removeResources.add(removeResourcesItem);
		return this;
	}

	/**
	 * List of resources that are approved to be removed, with one entry per
	 * resource. Shall be set when resources are approved to be removed.
	 *
	 * @return removeResources
	 **/
	@Schema(description = "List of resources that are approved to be removed, with one entry per resource. Shall be set when resources are approved to be removed. ")
	@Valid
	public List<GrantInfo> getRemoveResources() {
		return removeResources;
	}

	public void setRemoveResources(final List<GrantInfo> removeResources) {
		this.removeResources = removeResources;
	}

	public Grant updateResources(final List<GrantInfo> updateResources) {
		this.updateResources = updateResources;
		return this;
	}

	public Grant addUpdateResourcesItem(final GrantInfo updateResourcesItem) {
		if (this.updateResources == null) {
			this.updateResources = new ArrayList<>();
		}
		this.updateResources.add(updateResourcesItem);
		return this;
	}

	/**
	 * List of resources that are approved to be modified, with one entry per
	 * resource. Shall be set when resources are approved to be updated.
	 *
	 * @return updateResources
	 **/
	@Schema(description = "List of resources that are approved to be modified, with one entry per resource. Shall be set when resources are approved to be updated. ")
	@Valid
	public List<GrantInfo> getUpdateResources() {
		return updateResources;
	}

	public void setUpdateResources(final List<GrantInfo> updateResources) {
		this.updateResources = updateResources;
	}

	public Grant vimAssets(final GrantVimAssets vimAssets) {
		this.vimAssets = vimAssets;
		return this;
	}

	/**
	 * Get vimAssets
	 *
	 * @return vimAssets
	 **/
	@Schema(description = "")

	@Valid
	public GrantVimAssets getVimAssets() {
		return vimAssets;
	}

	public void setVimAssets(final GrantVimAssets vimAssets) {
		this.vimAssets = vimAssets;
	}

	public Grant extVirtualLinks(final List<ExtVirtualLinkData> extVirtualLinks) {
		this.extVirtualLinks = extVirtualLinks;
		return this;
	}

	public Grant addExtVirtualLinksItem(final ExtVirtualLinkData extVirtualLinksItem) {
		if (this.extVirtualLinks == null) {
			this.extVirtualLinks = new ArrayList<>();
		}
		this.extVirtualLinks.add(extVirtualLinksItem);
		return this;
	}

	/**
	 * Information about external VLs to connect the VNF to. External and/or
	 * externally-managed internal VLs can be passed in VNF lifecycle management
	 * operation requests such as InstantiateVnf, ChangeVnfFlavor,
	 * ChangeExtVnfConnectivity or ChangeCurrentVnfPackage and/or in the grant
	 * response. The NFVO may choose to override in the grant response external
	 * and/or externally-managed VL instances that have been passed previously in
	 * the associated VNF lifecycle management request, if the lifecycle management
	 * request has originated from the NFVO itself. In case of granting an
	 * InstantiateVnf request that has originated from the NFVO and that did not
	 * contain the \"extVirtualLinks\" attribute, this attribute shall be set by the
	 * NFVO. Further in case of granting an InstantiateVnf request that has
	 * originated from the NFVO and that did not contain the
	 * \"extManagedVirtualLinks\" attribute, this attribute shall be set by the NFVO
	 * if there is the need to provide information about externally-managed virtual
	 * links. If this attribute is present , it need not contain those entries that
	 * are unchanged compared to the entries that were passed in the LCM operation
	 * which is related to this granting exchange. External and/or
	 * externally-managed internal VLs can be passed in VNF lifecycle management
	 * operation requests such as InstantiateVnf, ChangeVnfFlavor,
	 * ChangeExtVnfConnectivity or ChangeCurrentVnfPackage and/or in the grant
	 * response. The NFVO may choose to override in the grant response external
	 * and/or externally-managed VL instances that have been passed previously in
	 * the associated VNF lifecycle management request, if the lifecycle management
	 * request has originated from the NFVO itself. In case of granting an
	 * InstantiateVnf request that has originated from the NFVO and that did not
	 * contain the \"extVirtualLinks\" attribute, this attribute shall be set by the
	 * NFVO. Further in case of granting an InstantiateVnf request that has
	 * originated from the NFVO and that did not contain the
	 * \"extManagedVirtualLinks\" attribute, this attribute shall be set by the NFVO
	 * if there is the need to provide information about externally-managed virtual
	 * links.
	 *
	 * @return extVirtualLinks
	 **/
	@Schema(description = "Information about external VLs to connect the VNF to. External and/or externally-managed internal VLs can be passed in VNF lifecycle management operation requests such as InstantiateVnf, ChangeVnfFlavor,  ChangeExtVnfConnectivity or ChangeCurrentVnfPackage and/or in the grant response.  The NFVO may choose to override in the grant response external and/or  externally-managed VL instances that have been passed previously in the  associated VNF lifecycle management request, if the lifecycle management request has originated from the NFVO itself. In case of granting an InstantiateVnf request that has originated from the NFVO  and that did not contain the \"extVirtualLinks\" attribute, this attribute shall be  set by the NFVO. Further in case of granting an InstantiateVnf request that has  originated from the NFVO and that did not contain the \"extManagedVirtualLinks\"  attribute, this attribute shall be set by the NFVO if there is the need to provide  information about externally-managed virtual links. If this attribute is present , it need not contain those entries that are unchanged compared to the entries that were passed in the LCM operation which is related to this granting exchange. External and/or externally-managed internal VLs can be passed in VNF lifecycle management operation requests such as InstantiateVnf, ChangeVnfFlavor,  ChangeExtVnfConnectivity or ChangeCurrentVnfPackage and/or in the grant response.  The NFVO may choose to override in the grant response external and/or  externally-managed VL instances that have been passed previously in the  associated VNF lifecycle management request, if the lifecycle management request has originated from the NFVO itself. In case of granting an InstantiateVnf request that has originated from the NFVO  and that did not contain the \"extVirtualLinks\" attribute, this attribute shall be  set by the NFVO. Further in case of granting an InstantiateVnf request that has  originated from the NFVO and that did not contain the \"extManagedVirtualLinks\"  attribute, this attribute shall be set by the NFVO if there is the need to provide  information about externally-managed virtual links. ")
	@Valid
	public List<ExtVirtualLinkData> getExtVirtualLinks() {
		return extVirtualLinks;
	}

	public void setExtVirtualLinks(final List<ExtVirtualLinkData> extVirtualLinks) {
		this.extVirtualLinks = extVirtualLinks;
	}

	public Grant extManagedVirtualLinks(final List<ExtManagedVirtualLinkData> extManagedVirtualLinks) {
		this.extManagedVirtualLinks = extManagedVirtualLinks;
		return this;
	}

	public Grant addExtManagedVirtualLinksItem(final ExtManagedVirtualLinkData extManagedVirtualLinksItem) {
		if (this.extManagedVirtualLinks == null) {
			this.extManagedVirtualLinks = new ArrayList<>();
		}
		this.extManagedVirtualLinks.add(extManagedVirtualLinksItem);
		return this;
	}

	/**
	 * Information about internal VLs that are managed by other entities than the
	 * VNFM. The indication of externally-managed internal VLs is needed in case
	 * networks have been pre-configured for use with certain VNFs, for instance to
	 * ensure that these networks have certain properties such as security or
	 * acceleration features, or to address particular network topologies. The
	 * present document assumes that externally-managed internal VLs are managed by
	 * the NFVO and created towards the VIM. External and/or externally-managed
	 * internal VLs can be passed in VNF lifecycle management operation requests
	 * such as InstantiateVnf, ChangeVnfFlavor, ChangeExtVnfConnectivity or
	 * ChangeCurrentVnfPackage and/or in the grant response. The NFVO may choose to
	 * override in the grant response external and/or externally-managed VL
	 * instances that have been passed previously in the associated VNF lifecycle
	 * management request, if the lifecycle management request has originated from
	 * the NFVO itself. In case of granting an InstantiateVnf request that has
	 * originated from the NFVO and that did not contain the \"extVirtualLinks\"
	 * attribute, this attribute shall be set by the NFVO. Further in case of
	 * granting an InstantiateVnf request that has originated from the NFVO and that
	 * did not contain the \"extManagedVirtualLinks\" attribute, this attribute
	 * shall be set by the NFVO if there is the need to provide information about
	 * externally-managed virtual links.
	 *
	 * @return extManagedVirtualLinks
	 **/
	@Schema(description = "Information about internal VLs that are managed by other entities than the VNFM. The indication of externally-managed internal VLs is needed in case networks have been pre-configured for use with certain VNFs, for instance to ensure that these networks have certain properties such as security or acceleration features, or to address particular network topologies. The present document assumes that externally-managed internal VLs are managed by the NFVO and created towards the VIM. External and/or externally-managed internal VLs can be passed in VNF lifecycle management operation requests such as InstantiateVnf, ChangeVnfFlavor,  ChangeExtVnfConnectivity or ChangeCurrentVnfPackage and/or in the grant response.  The NFVO may choose to override in the grant response external and/or  externally-managed VL instances that have been passed previously in the  associated VNF lifecycle management request, if the lifecycle management request has originated from the NFVO itself. In case of granting an InstantiateVnf request that has originated from the NFVO  and that did not contain the \"extVirtualLinks\" attribute, this attribute shall be  set by the NFVO. Further in case of granting an InstantiateVnf request that has  originated from the NFVO and that did not contain the \"extManagedVirtualLinks\"  attribute, this attribute shall be set by the NFVO if there is the need to provide  information about externally-managed virtual links. ")
	@Valid
	public List<ExtManagedVirtualLinkData> getExtManagedVirtualLinks() {
		return extManagedVirtualLinks;
	}

	public void setExtManagedVirtualLinks(final List<ExtManagedVirtualLinkData> extManagedVirtualLinks) {
		this.extManagedVirtualLinks = extManagedVirtualLinks;
	}

	public Grant additionalParams(final Map<String, String> additionalParams) {
		this.additionalParams = additionalParams;
		return this;
	}

	/**
	 * Get additionalParams
	 *
	 * @return additionalParams
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(final Map<String, String> additionalParams) {
		this.additionalParams = additionalParams;
	}

	public Grant links(final GrantLinks _links) {
		this.links = _links;
		return this;
	}

	/**
	 * Get _links
	 *
	 * @return _links
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public GrantLinks getLinks() {
		return links;
	}

	public void setLinks(final GrantLinks _links) {
		this.links = _links;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final Grant grant = (Grant) o;
		return Objects.equals(this.id, grant.id) &&
				Objects.equals(this.vnfInstanceId, grant.vnfInstanceId) &&
				Objects.equals(this.vnfLcmOpOccId, grant.vnfLcmOpOccId) &&
				Objects.equals(this.vimConnectionInfo, grant.vimConnectionInfo) &&
				Objects.equals(this.zones, grant.zones) &&
				Objects.equals(this.zoneGroups, grant.zoneGroups) &&
				Objects.equals(this.addResources, grant.addResources) &&
				Objects.equals(this.tempResources, grant.tempResources) &&
				Objects.equals(this.removeResources, grant.removeResources) &&
				Objects.equals(this.updateResources, grant.updateResources) &&
				Objects.equals(this.vimAssets, grant.vimAssets) &&
				Objects.equals(this.extVirtualLinks, grant.extVirtualLinks) &&
				Objects.equals(this.extManagedVirtualLinks, grant.extManagedVirtualLinks) &&
				Objects.equals(this.additionalParams, grant.additionalParams) &&
				Objects.equals(this.links, grant.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, vnfInstanceId, vnfLcmOpOccId, vimConnectionInfo, zones, zoneGroups, addResources, tempResources, removeResources, updateResources, vimAssets, extVirtualLinks, extManagedVirtualLinks, additionalParams, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class Grant {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    vnfInstanceId: ").append(toIndentedString(vnfInstanceId)).append("\n");
		sb.append("    vnfLcmOpOccId: ").append(toIndentedString(vnfLcmOpOccId)).append("\n");
		sb.append("    vimConnectionInfo: ").append(toIndentedString(vimConnectionInfo)).append("\n");
		sb.append("    zones: ").append(toIndentedString(zones)).append("\n");
		sb.append("    zoneGroups: ").append(toIndentedString(zoneGroups)).append("\n");
		sb.append("    addResources: ").append(toIndentedString(addResources)).append("\n");
		sb.append("    tempResources: ").append(toIndentedString(tempResources)).append("\n");
		sb.append("    removeResources: ").append(toIndentedString(removeResources)).append("\n");
		sb.append("    updateResources: ").append(toIndentedString(updateResources)).append("\n");
		sb.append("    vimAssets: ").append(toIndentedString(vimAssets)).append("\n");
		sb.append("    extVirtualLinks: ").append(toIndentedString(extVirtualLinks)).append("\n");
		sb.append("    extManagedVirtualLinks: ").append(toIndentedString(extManagedVirtualLinks)).append("\n");
		sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
		sb.append("    _links: ").append(toIndentedString(links)).append("\n");
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
