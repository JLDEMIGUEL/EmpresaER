package com.vipera.empresaer.rest.utils.schedulingtasks;


import com.vipera.empresaer.core.components.cliente.ClienteCore;
import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.rest.converters.cliente.ClienteRequestToClienteConverter;
import com.vipera.empresaer.rest.converters.cliente.ClienteToClienteResponseConverter;
import com.vipera.empresaer.rest.requests.ClienteRequest;
import com.vipera.empresaer.rest.requests.DireccionRequest;
import com.vipera.empresaer.rest.responses.cliente.ClienteResponse;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//@Component
public class ScheduledTasks {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private ClienteCore core;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        LOGGER.info(LogUtils.restMarker,"REST -   ScheduledTasks   - reportCurrentTime - Current Time: "
                +dateFormat.format(new Date()));
    }

    @Scheduled(fixedRate = 10 * 60 * 1000, initialDelay = 5 * 60 * 1000)
    public void addClient(){
        try{
            LOGGER.info(LogUtils.restMarker,"REST -   ScheduledTasks   - INPUT - addClient - Saving cliente");

            ClienteRequest model = new ClienteRequest(); DireccionRequest direccion =new DireccionRequest(); direccion.setId(2L);
            model.setNombre("ClienteScheduled"); model.setTelefono("123456789");model.setDireccion(direccion);
            Cliente cliente = new ClienteRequestToClienteConverter().convert(model);

            Cliente clienteSaved = core.save(cliente);

            if (clienteSaved == null)
                LOGGER.error(LogUtils.restMarker,"REST -   ScheduledTasks   - ERROR - addClient - Error while saving cliente");

            ClienteResponse clienteResponse = new ClienteToClienteResponseConverter().convert(clienteSaved);

            LOGGER.info(LogUtils.restMarker,"REST -   ScheduledTasks   - OUTPUT - addClient - Cliente saved ");
        }catch (RestException exception){
            LOGGER.error(LogUtils.restMarker,"REST -   ScheduledTasks   - ERROR - addClient - Unable to save cliente");
        }
    }

    @Scheduled(fixedRate = 10 * 60 * 1000, initialDelay = 10 * 1000)
    public void checkClients(){
        try{
            LOGGER.info(LogUtils.restMarker,"REST -   ScheduledTasks   - INPUT - checkClients - Checking all cliente");

            List<Cliente> allClientes = core.findAll();
            Cliente cl;

            for (Cliente cliente : allClientes) {
                cl = core.findById(cliente.getId());
            }

            LOGGER.info(LogUtils.restMarker,"REST -   ScheduledTasks   - OUTPUT - checkClients - Checked all cliente ");
        }catch (RestException exception){
            LOGGER.error(LogUtils.restMarker,"REST -   ScheduledTasks   - ERROR - checkClients - Unable to check cliente");
        }
    }
}

