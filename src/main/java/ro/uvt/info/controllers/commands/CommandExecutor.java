package ro.uvt.info.controllers.commands;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CommandExecutor {
    public <T1,T2> T1 execute(Command<T1,T2> cmd){
        return cmd.execute();
    }

    public <T1,T2> void executeAsync(Command<T1,T2> cmd){

    }

}
