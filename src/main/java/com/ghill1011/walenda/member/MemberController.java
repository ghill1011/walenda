package com.ghill1011.walenda.member;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ghill1011.walenda.PoolManager;

@RestController
public class MemberController {

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
