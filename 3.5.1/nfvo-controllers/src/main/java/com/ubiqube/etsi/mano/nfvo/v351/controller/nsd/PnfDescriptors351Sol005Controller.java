package com.ubiqube.etsi.mano.nfvo.v351.controller.nsd;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.function.Consumer;

import javax.annotation.Nonnull;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nsd.PnfFrontController;
import com.ubiqube.etsi.mano.nfvo.v351.model.nsd.CreatePnfdInfoRequest;
import com.ubiqube.etsi.mano.nfvo.v351.model.nsd.Link;
import com.ubiqube.etsi.mano.nfvo.v351.model.nsd.PnfdInfo;
import com.ubiqube.etsi.mano.nfvo.v351.model.nsd.PnfdInfoLinks;
import com.ubiqube.etsi.mano.nfvo.v351.model.nsd.PnfdInfoModifications;

/**
 *
 * @author Olivier Vignaud <ovi@ubiqube.com>
 *
 */
@RestController
public class PnfDescriptors351Sol005Controller implements PnfDescriptors351Sol005Api {
	private final PnfFrontController pnfFrontController;

	public PnfDescriptors351Sol005Controller(final PnfFrontController pnfFrontController) {
		super();
		this.pnfFrontController = pnfFrontController;
	}

	/**
	 * Query information about multiple PNF descriptor resources.
	 *
	 * \&quot;The GET method queries information about multiple PNF descriptor
	 * resources.\&quot;
	 *
	 */
	@Override
	public ResponseEntity<String> pnfDescriptorsGet(@Nonnull final MultiValueMap<String, String> requestParams) {
		final Consumer<PnfdInfo> setLink = x -> x.setLinks(makeLinks(x));
		return pnfFrontController.search(requestParams, PnfdInfo.class, setLink);
	}

	/**
	 * Delete an individual PNF descriptor resource.
	 *
	 * The DELETE method deletes an individual PNF descriptor resource. An
	 * individual PNF descriptor resource can only be deleted when there is no NS
	 * instance using it or there is NSD referencing it. To delete all PNFD versions
	 * identified by a particular value of the \&quot;pnfdInvariantId\&quot;
	 * attribute, the procedure is to first use the GET method with filter
	 * \&quot;pnfdInvariantId\&quot; towards the PNF descriptors resource to find
	 * all versions of the PNFD. Then, the client uses the DELETE method described
	 * in this clause to delete each PNFD version individually.
	 *
	 */
	@Override
	public ResponseEntity<Void> pnfDescriptorsPnfdInfoIdDelete(final String pnfdInfoId) {
		return pnfFrontController.delete(pnfdInfoId);
	}

	/**
	 * Read an individual PNFD resource.
	 *
	 * The GET method reads information about an individual PNF descriptor. This
	 * method shall follow the provisions specified in the Tables 5.4.6.3.2-1 and
	 * 5.4.6.3.2-2 of GS NFV-SOL 005 for URI query parameters, request and response
	 * data structures, and response codes.
	 *
	 */
	@Override
	public ResponseEntity<PnfdInfo> pnfDescriptorsPnfdInfoIdGet(final String pnfdInfoId) {
		return pnfFrontController.findById(pnfdInfoId, PnfdInfo.class, PnfDescriptors351Sol005Controller::makeLinks);
	}

	/**
	 * Modify the user defined data of an individual PNF descriptor resource.
	 *
	 * The PATCH method modifies the user defined data of an individual PNF
	 * descriptor resource.
	 *
	 */
	@Override
	public ResponseEntity<PnfdInfoModifications> pnfDescriptorsPnfdInfoIdPatch(final String pnfdInfoId, final PnfdInfoModifications body) {
		return pnfFrontController.modify(pnfdInfoId, null, body);
	}

	/**
	 * Fetch the content of a PNFD.
	 *
	 * The GET method fetches the content of the PNFD. This method shall follow the
	 * provisions specified in the Table 5.4.7.3.2-2 for URI query parameters,
	 * request and response data structures, and response codes.
	 *
	 */
	@Override
	public ResponseEntity<Void> pnfDescriptorsPnfdInfoIdPnfdContentGet(final String pnfdInfoId, final String range) {
		return pnfFrontController.getContent(pnfdInfoId, range);
	}

	/**
	 * Upload the content of a PNFD.
	 *
	 * The PUT method is used to upload the content of a PNFD. This resource
	 * represents the content of the individual PNF descriptor, i.e. PNFD content.
	 * The client can use this resource to upload and download the content of the
	 * PNFD.
	 *
	 */
	@Override
	public ResponseEntity<Void> pnfDescriptorsPnfdInfoIdPnfdContentPut(final String pnfdInfoId, final String contentType) {
		return pnfFrontController.putContent(pnfdInfoId, contentType);
	}

	/**
	 * Create a new PNF descriptor resource.
	 *
	 * The POST method is used to create a new PNF descriptor resource
	 *
	 */
	@Override
	public ResponseEntity<PnfdInfo> pnfDescriptorsPost(final CreatePnfdInfoRequest body) {
		return pnfFrontController.create(body.getUserDefinedData(), PnfdInfo.class, PnfDescriptors351Sol005Controller::makeLinks);
	}

	@Override
	public ResponseEntity<Void> pnfDescriptorsPnfdInfoIdManifestGet(final String pnfdInfoId, @Valid final String includeSignatures) {
		return pnfFrontController.manifestGet(pnfdInfoId, includeSignatures);
	}

	@Override
	public ResponseEntity<Void> pnfDescriptorsPnfdInfoIdPnfdGet(final String pnfdInfoId, final String range, @Valid final String includeSignatures) {
		return pnfFrontController.getPnfd(pnfdInfoId, range, includeSignatures);
	}

	@Override
	public ResponseEntity<Void> pnfDescriptorsPnfdInfoIdArtifactsArtifactPathGet(final String pnfdInfoId, final String artifactPath, final String range, @Valid final String includeSignatures) {
		return pnfFrontController.getArtifact(pnfdInfoId, artifactPath, range, includeSignatures);
	}

	private static PnfdInfoLinks makeLinks(final PnfdInfo x) {
		final PnfdInfoLinks links = new PnfdInfoLinks();
		final Link pnfdContent = new Link();
		pnfdContent.setHref(linkTo(methodOn(PnfDescriptors351Sol005Api.class).pnfDescriptorsPnfdInfoIdPnfdContentGet(x.getId(), "")).withSelfRel().getHref());
		links.setPnfdContent(pnfdContent);
		final Link self = new Link();
		self.setHref(linkTo(methodOn(PnfDescriptors351Sol005Api.class).pnfDescriptorsPnfdInfoIdGet(x.getId())).withSelfRel().getHref());
		links.setSelf(self);

		return null;
	}

}
