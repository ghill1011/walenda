package walenda;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class WalendaController {

  @RequestMapping("/")
  public String index() {
    return "Welcome to Gregg's Points Bank";
  }

  @RequestMapping("/notsupported")
  public String notSupported() {
    return "sorry.  operation is not supported";
  }

  //get organizations
  @RequestMapping(value = "/organizations", method = RequestMethod.GET)
  public List<String> getOrganizations() {
    List<String> list = OrganizationDAO.getAll();
    return list;
  }

  //append a new organization to the organization list
  @RequestMapping(value = "/organizations/{organization}", method = RequestMethod.POST)
  public void insertOrganization(@PathVariable String organization) {
    OrganizationDAO.insert(organization);
    return;
  }

  //append a new organization to the organization list
  @RequestMapping(value = "/organizations/{organization}", method = RequestMethod.DELETE)
  public void deleteOrganization(@PathVariable String organization) {
    OrganizationDAO.delete(organization);
    return;
  }

  //would replace the organizations list but we aren't going to do that.
  @RequestMapping(value = "/organizations", method = RequestMethod.PUT)
  public String replaceOrganizations() {
    return "redirect:/notsupported";
  }

  //get all members of the organization
  @RequestMapping(value = "/{organization}/members", method = RequestMethod.GET)
  public List<String> getMembers(@PathVariable String organization) {
    List<String> list = MemberDAO.getAll(organization);
    return list;
  }

  //add a member to an organization
  @RequestMapping(value = "/{organization}/members/{member}", method = RequestMethod.POST)
  public void getMembers(@PathVariable String organization, @PathVariable String member) {
    MemberDAO.insert(organization, member);
    return;
  }

  //delete a member from an organization
  @RequestMapping(value = "/{organization}/members/{member}", method = RequestMethod.DELETE)
  public void deletePartner(@PathVariable String organization, @PathVariable String member) {
    MemberDAO.delete(organization, member);
    return;
  }

  //get all members of the organization
  @RequestMapping(value = "/{organization}/members", method = RequestMethod.PUT)
  public String replaceMembers(@PathVariable String organization) {
    return "redirect:/notsupported";
  }

}
