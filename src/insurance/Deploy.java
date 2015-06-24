package insurance;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Deploy {
  public void deployrool(int violationtime) throws Exception {
   // TODO Auto-generated method stub
	      Violation v=new Violation();
      try {
    	  KieServices ks = KieServices.Factory.get();
  	      KieContainer kContainer = ks.getKieClasspathContainer();
      	  //KieSession kSession = kContainer.newKieSession("ksession-rules");
  	      KieSession kSession = kContainer.newKieSession("ksession-rules");
          v.setViolationtime(violationtime);
          kSession.insert(v);
          kSession.fireAllRules();
          System.out.print("Violation Time:"+v.getViolationtime());
      } catch (Throwable t) {
      t.printStackTrace();
      }  

  }

  private KnowledgeBase readKnowledgeBase() throws Exception {
     KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
     kbuilder.add(ResourceFactory.newClassPathResource("insurancerules.drl"), ResourceType.DRL);
     KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
             for (KnowledgeBuilderError error : errors) {
                  System.err.println(error);
                        }
     throw new IllegalArgumentException("Could not parse knowledge.");
       }
      KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
      kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
      return kbase;
     }
} 
