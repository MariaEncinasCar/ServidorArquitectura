/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

/**
 *
 * @author Equipo 6
 */
public class FabricaAgentes {
    private AgenteUsuario agUsuario;
    private AgentePublicacion agPublicacion;
    
    public AgenteUsuario getrAgenteUsuario() {
        if(agUsuario!=null){
            return agUsuario;
        }else{
            agUsuario = new AgenteUsuario();
            return agUsuario;
        }
    }
    
    public AgentePublicacion getrAgentePublicacion() {
        if(agPublicacion!=null){
            return agPublicacion;
        }else{
            agPublicacion = new AgentePublicacion();
            return agPublicacion;
        }
    }
}
