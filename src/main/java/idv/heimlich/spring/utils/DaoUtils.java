package idv.heimlich.spring.utils;

import idv.heimlich.spring.dao.OrgDao;
import idv.heimlich.spring.domain.OrgDo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DaoUtils {
	
	public final String CREATE_OPERATION = "CREATE";
	public final String READ_OPERATION = "READ";
	public final String UPDATE_OPERATION = "UPDATE";
	public final String DELETE_OPERATION = "DELETE";
	public final String CLEANUP_OPERATION = "TRUNCATE";
	
	public void printOrg(List<OrgDo> orgs, String operation) {
		System.out.println("\n****** printing orgs after " + operation + " operation ******\n");
		for (OrgDo orgDo : orgs) {
			System.out.println(orgDo);
		}
	}
	
	public void printOrg(OrgDo orgDo ,String operation) {
		System.out.println("\n****** printing orgs after invoking " + operation + " ******\n" + orgDo);
	}
	
	public void printSuccessFailure(String operation, boolean param) {
		if (param) {
			System.out.println("\nOperation " + operation + " successful");
		} else {
			System.out.println("\nOperation " + operation + " failed");
		}
	}
	
	public void createSeedDate(OrgDao dao) {
		OrgDo arg1 = new OrgDo("TEST1", 2001, "AAAAA");
		OrgDo arg2 = new OrgDo("TEST2", 2002, "BBBBB");
		
		List<OrgDo> orgs = new ArrayList<OrgDo>();
		orgs.add(arg1);
		orgs.add(arg2);
		
		int createCount = 0;
		for (OrgDo orgDo : orgs) {
			boolean isCreated = dao.create(orgDo);
			if (isCreated) {
				createCount += 1;
			}
		}
		
		System.out.println("Created " + createCount + " orgs");
	}
	
	public void printOrgCount(List<OrgDo> orgs, String operation) {
		System.out.println("\n****** currently we have " + orgs.size() + " orgs after " + operation + " operation" + " ******");
	}

}
