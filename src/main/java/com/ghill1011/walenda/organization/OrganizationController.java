package com.ghill1011.walenda.organization;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class OrganizationController {

  //get organization home
  /*
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String getHome() {
      return "Greetings from Gregg's first Spring Boot app running in PCF!\n";
  }
  */

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

}
