import {Form, Formik} from 'formik';
import {Alert, Button, CircularProgress, Paper} from '@mui/material';
import * as Yup from 'yup';
import TextFieldInput from "./TextFieldInput";
import Container from "@mui/material/Container";
//import {createAccount} from "../../api/accountApi";
import {useState} from "react";

const validationSchema = Yup.object().shape({
    id: Yup.string()
        .min(5, 'Value must be 5 or more')
        .max(12, 'Value must be 12 or less')
        .required(),
    name: Yup.string()
        .min(5, 'Value must be 5 or more')
        .max(20, 'Value must be 20 or less')
        .required()
});

export default () => {
    const [notification, setNotification] = useState({isVisible: false, message:'', severity: ''});

    // const onCreateClient = (client, helpers) => {
    //     createClient(client)
    //         .then(({status}) => {
    //             if(status === 201) {
    //                 setNotification({isVisible: true, message: 'Client created successfully', severity: 'success'});
    //                 helpers.resetForm();
    //             }
    //         })
    //         .catch((error) => setNotification({isVisible: true, message: 'Something goes wrong', severity: 'error'}))
    //         .finally(() => helpers.setSubmitting(false));
    // }

    return (

        <Formik initialValues={{
            id: '',
            name: ''
        }}
            //                onSubmit={onCreateClient}
                validationSchema={validationSchema}>
            {props => (
                <Container maxWidth="sm">
                    <Paper elevation={3} sx={{p: 1}}>
                        {
                            notification.isVisible &&
                            <Alert severity={notification.severity} sx={{ width: '100%' }}>
                                {notification.message}
                            </Alert>
                        }
                        <Form>
                            <h2>Client creation form:</h2>
                            <TextFieldInput error={props.touched.id && !!props.errors.id}
                                            fieldName="id"
                                            label="Client identification number:"
                                            placeholder="Type client identification number..."/>
                            <TextFieldInput error={props.touched.name && !!props.errors.name}
                                            fieldName="name"
                                            label="Client name:"
                                            placeholder="Type client name..."/>
                            {
                                props.isSubmitting ? <CircularProgress/> : <Button type="submit">Submit</Button>
                            }
                        </Form>
                    </Paper>
                </Container>
            )}
        </Formik>
    )
}