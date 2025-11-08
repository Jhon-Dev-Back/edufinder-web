package controller;

import entities.CorreoDestinatarios;
import entities.Correos;

import javax.mail.PasswordAuthentication;
import entities.Especialidades;
import entities.Roles;
import entities.TiposDocumento;
import entities.Usuarios;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Part;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import services.CorreoDestinatariosFacadeLocal;
import services.CorreosFacadeLocal;
import services.EspecialidadesFacadeLocal;
import services.RolesFacadeLocal;
import services.TiposDocumentoFacadeLocal;
import services.UsuariosFacadeLocal;

@Named(value = "controllerDeUsuarios")
@SessionScoped
public class controllerDeUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    Usuarios user = new Usuarios();
    Roles rol = new Roles();
    Especialidades esp = new Especialidades();
    TiposDocumento tipod = new TiposDocumento();
    Correos correo = new Correos();
    private String destinatarios;
    private String asunto;
    private String mensaje;
    private Part file;
    private Date date = new Date();

    @EJB
    UsuariosFacadeLocal ufl;
    @EJB
    CorreosFacadeLocal corfl;
    @EJB
    CorreoDestinatariosFacadeLocal cordesfl;
    @EJB
    RolesFacadeLocal rlf;
    @EJB
    EspecialidadesFacadeLocal spcl;
    @EJB
    TiposDocumentoFacadeLocal tp;

    List<SelectItem> listaRoles;
    List<SelectItem> listarEspecialidades;
    List<SelectItem> listarDocumento;
    List<SelectItem> listarAdmins;

    // --- GETTERS Y SETTERS ---
    public String getDestinatarios() {
        return destinatarios;
    }

    public Correos getCorreo() {
        return correo;
    }

    public void setCorreo(Correos correo) {
        this.correo = correo;
    }

    public void setDestinatarios(String destinatarios) {
        this.destinatarios = destinatarios;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public Especialidades getEsp() {
        return esp;
    }

    public void setEsp(Especialidades esp) {
        this.esp = esp;
    }

    public TiposDocumento getTipod() {
        return tipod;
    }

    public void setTipod(TiposDocumento tipod) {
        this.tipod = tipod;
    }

    public controllerDeUsuarios() {
    }

    
    public List<Usuarios> listarUsuariosProfesionales() {
        try {
            return ufl.findByProfesional(2);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Usuarios> listarUsuariosCliente() {
        try {
            return ufl.findByCliente(4);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Usuarios> listarUsuariosAdministrador() {
        try {
            return ufl.findByCliente(1);
        } catch (Exception e) {
            return null;
        }
    }

    public List<SelectItem> listarUsuariosAdmin() {
        listarAdmins = new ArrayList<>();
        try {
            for (Usuarios u : ufl.findAll()) {
                if ("Administrador".equalsIgnoreCase(u.getRolId().getNombre())) {
                    listarAdmins.add(new SelectItem(u.getId(), u.getNombres()));
                }
            }
            return listarAdmins;
        } catch (Exception e) {
            return null;
        }
    }

    public List<SelectItem> listarRoles() {
        listaRoles = new ArrayList<>();
        try {
            for (Roles r : rlf.findAll()) {
                listaRoles.add(new SelectItem(r.getId(), r.getNombre()));
            }
            return listaRoles;
        } catch (Exception e) {
            return null;
        }
    }

    public List<SelectItem> listarRolCliente() {
        listaRoles = new ArrayList<>();
        try {
            for (Roles r : rlf.findAll()) {
                if ("Cliente".equalsIgnoreCase(r.getNombre())) {
                    listaRoles.add(new SelectItem(r.getId(), r.getNombre()));
                }
            }
            return listaRoles;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SelectItem> listarEspecialidades() {
        listarEspecialidades = new ArrayList<>();
        try {
            for (Especialidades e : spcl.findAll()) {
                listarEspecialidades.add(new SelectItem(e.getId(), e.getNombre()));
            }
            return listarEspecialidades;
        } catch (Exception e) {
            return null;
        }
    }

    public List<SelectItem> listarTipodeDocu() {
        listarDocumento = new ArrayList<>();
        try {
            for (TiposDocumento t : tp.findAll()) {
                listarDocumento.add(new SelectItem(t.getId(), t.getCodigo()));
            }
            return listarDocumento;
        } catch (Exception e) {
            return null;
        }
    }

    public void cancelar() {
        user = new Usuarios();
        rol = new Roles();
        tipod = new TiposDocumento();
        esp = new Especialidades();
    }

    public void crearUsuarios() {
        try {
           
            if (user.getNumeroDocumento().matches("\\d+")) {

                if (user.getCorreoElectronico().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                    user.setRolId(rlf.find(rol.getId()));
                    user.setEspecialidadId(spcl.find(esp.getId()));
                    user.setFechaRegistro(new Date());
                    user.setTipoDocumentoId(tp.find(tipod.getId()));
                    ufl.create(user);
                    user = new Usuarios();
                    rol = new Roles();
                    tipod = new TiposDocumento();
                    esp = new Especialidades();
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Registrado Exitosamente", null));

                } else {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar usuario, correo  invalido valide sus datos por favor", null));
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar usuario, documento  invalido valide sus datos por favor", null));
            }

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Registrar usuario/Valide que no halla campos sin seleccionar"+ e.getMessage(), null));
            e.printStackTrace();
        }

    }

    public void editarUsuarioUno(Usuarios user) {
        this.user = user;
        this.esp.setId(user.getEspecialidadId().getId());
        this.rol.setId(user.getRolId().getId());
        this.tipod.setId(user.getTipoDocumentoId().getId());
    }

    public void actualizarUsuario() {
        try {
            
            if (user.getContraseña() == null || user.getContraseña().trim().isEmpty()) {
                Usuarios usuarioExistente = ufl.find(user.getId());
                user.setContraseña(usuarioExistente.getContraseña());
                
            }
             if (user.getCorreoElectronico() != null &&  !user.getCorreoElectronico().isEmpty() && user.getCorreoElectronico().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$") ) {
                 
            user.setRolId(rlf.find(rol.getId()));
            user.setEspecialidadId(spcl.find(esp.getId()));
            user.setTipoDocumentoId(tp.find(tipod.getId()));

            ufl.edit(user);

            user = new Usuarios();
            rol = new Roles();
            tipod = new TiposDocumento();
            esp = new Especialidades();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Editado Exitosamente", null));
            }else{
                   FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar el  usuario, correo  invalido/ o el campo esta vacio\n "
                                    + "Verfique sus datos por favor", null));
             }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar usuario: " + e.getMessage(), null));
        }

    }

    public void procesarUsuariosCsv() {
        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord record : records) {
                Usuarios usuario = new Usuarios();
                usuario.setNombres(record.get("nombres"));
                usuario.setPrimerApellido(record.get("primer_apellido"));
                usuario.setSegundoApellido(record.get("segundo_apellido"));
                if (ufl.findByIdentificacion(record.get("identificacion")) == null) {
                    usuario.setNumeroDocumento(record.get("identificacion"));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Hay un documento que ya esta en uso y coinicide con el del nuevo usuario " + usuario.getNombres(), null));
                }
                if (ufl.findByEmail(record.get("correo")) == null) {
                    usuario.setCorreoElectronico(record.get("correo"));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Hay un correo que ya esta en uso  y coinicide con el del nuevo usuario " + usuario.getNombres(), null));
                }
                usuario.setFechaRegistro(date);
                usuario.setEdad(Integer.valueOf(record.get("edad")));
                usuario.setContraseña(record.get("contrasena"));
                if (ufl.findByAd(record.get("nombre_usuario")) == null) {
                    usuario.setNombreUsuario(record.get("nombre_usuario"));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Hay un nombre de usuario que ya esta en uso y coinicide con el del nuevo usuario " + usuario.getNombres(), null));
                }

                // Mapear especialidad
                int especialidad;
                switch (record.get("especialidad")) {
                    case "Aprendiz":
                        especialidad = 1;
                        break;
                    case "Ingenieria en Sistemas":
                        especialidad = 2;
                        break;
                    case "Comunicaciones":
                        especialidad = 3;
                        break;
                    case "Derecho":
                        especialidad = 4;
                        break;
                    case "Medicina":
                        especialidad = 5;
                        break;
                    case "Economia":
                        especialidad = 6;
                        break;
                    default:
                        throw new IllegalArgumentException("Especialidad no válida: " + record.get("especialidad"));

                }
                usuario.setEspecialidadId(spcl.find(especialidad));

                int rolId;
                switch (record.get("rol")) {
                    case "Administrador":
                        rolId = 1;
                        break;
                    case "Profesional":
                        rolId = 2;
                        break;
                    case "Entidad":
                        rolId = 3;
                        break;
                    case "Cliente":
                        rolId = 4;
                        break;
                    default:
                        throw new IllegalArgumentException("Rol no válido: " + record.get("rol"));
                }
                usuario.setRolId(rlf.find(rolId));

                int tipo;
                switch (record.get("Tipo_de_Documento")) {
                    case "CC":
                    case "Cedula de Ciudadania":
                        tipo = 1;
                        break;
                    case "TI":
                    case "Tarjeta de Identidad":
                        tipo = 2;
                        break;
                    case "CE":
                    case "Extranjeria":
                        tipo = 3;
                        break;
                    default:
                        throw new IllegalArgumentException("Documento no válido: " + record.get("Tipo_de_Documento"));
                }
                usuario.setTipoDocumentoId(tp.find(tipo));

                ufl.create(usuario);
            }
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuarios cargados desde CSV correctamente", null));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al procesar CSV: " + e.getMessage(), null));
        }
    }

    public void enviarCorreoJSF() {
        try {
            if (destinatarios == null || destinatarios.trim().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe ingresar al menos un destinatario", null));
                return;
            }

            String[] listaDestinatarios = destinatarios.split(",");

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("jhonerrtes1@gmail.com", "bzqcspwvdhadnxdk");
                }
            });

            for (String correoLit : listaDestinatarios) {
                correoLit = correoLit.trim();
                if (!correoLit.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Correo inválido detectado: " + correoLit, null));
                    return;
                }

                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress("jhonerrtes1@gmail.com"));
                msg.setRecipient(Message.RecipientType.TO, new InternetAddress(correoLit));
                msg.setSubject(asunto);
                msg.setText(mensaje);

                Transport.send(msg);
                Usuarios usuarioLogueado = (Usuarios) FacesContext.getCurrentInstance()
                        .getExternalContext().getSessionMap().get("usuario");

                Correos nuevoCorreo = new Correos();
                nuevoCorreo.setRemitenteId(usuarioLogueado);
                nuevoCorreo.setAsunto(asunto);
                nuevoCorreo.setDetalle(mensaje);
                nuevoCorreo.setFechaEnvio(date);
                corfl.create(nuevoCorreo);
                CorreoDestinatarios dest = new CorreoDestinatarios();
                Usuarios destinatarario = ufl.findByEmail(correoLit);
                if (destinatarario != null) {
                    dest.setDestinatarioId(destinatarario);
                    dest.setCorreoExternos(destinatarario.getCorreoElectronico());
                } else {
                    dest.setCorreoExternos(correoLit);
                }
                dest.setDestinatarioId(usuarioLogueado);
                dest.setIdcorreo(nuevoCorreo);

                cordesfl.create(dest);

            }
            destinatarios = "";
            mensaje = "";
            asunto = "";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Correo enviado correctamente", null));

        } catch (MessagingException e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al enviar correo: " + e.getMessage(), null));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error inesperado: " + e.getMessage(), null));
        }
    }

    public void EliminarUsuarios(Usuarios user) {
        try {
            ufl.remove(user);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Eliminado Exitosamente", null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
