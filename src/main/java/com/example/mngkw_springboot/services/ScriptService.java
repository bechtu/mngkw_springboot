package com.example.mngkw_springboot.services;

import com.example.mngkw_springboot.repository.CampsRepository;
import com.example.mngkw_springboot.repository.ExercisesRepository;
import com.example.mngkw_springboot.repository.InstructorsRepository;
import lombok.extern.slf4j.Slf4j;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.PolyglotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ScriptService {

    private final CampsService campsService;
    private final CampsRepository campsRepository;
    private final InstructorsService instructorsService;
    private final InstructorsRepository instructorsRepository;
    private final ExercisesService exercisesService;
    private final ExercisesRepository exercisesRepository;

    @Autowired
    public ScriptService(CampsService campsService, InstructorsService instructorsService, ExercisesService exercisesService,
                         CampsRepository campsRepository, InstructorsRepository instructorsRepository, ExercisesRepository exercisesRepository) {
        this.campsService = campsService;
        this.instructorsService = instructorsService;
        this.exercisesService = exercisesService;
        this.campsRepository = campsRepository;
        this.instructorsRepository = instructorsRepository;
        this.exercisesRepository = exercisesRepository;
    }
    public String exec (String script) {
        try (Context context = Context.newBuilder("js")
                .allowAllAccess(true)
                .build())
        {
            var bindings =context.getBindings("js");
            bindings.putMember("CS", campsService);
            bindings.putMember("CR", campsRepository);
            bindings.putMember("IS", instructorsService);
            bindings.putMember("IR", instructorsRepository);
            bindings.putMember("ES", exercisesService);
            bindings.putMember("ER", exercisesRepository);
            return context.eval("js",script).toString();
        }
        catch (PolyglotException e){
            log.error("Error executing", e);
            return e.getMessage()+ "\n" +e.getSourceLocation().toString();
        }
    }

}
