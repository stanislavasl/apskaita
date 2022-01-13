import {Form, Formik} from 'formik';
import {Alert, Button, CircularProgress, Paper} from '@mui/material';
import * as Yup from 'yup';
import TextFieldInput from "./TextFieldInput";
import Container from "@mui/material/Container";
//import {createAccount} from "../../api/accountApi";
import {useState} from "react";

const validationSchema = Yup.object().shape({
    id: Yup.string()
        .min(2, 'Value must be more than 2')
        .required(),
    name: Yup.string()
        .max(80, 'Value must be less than 120')
        .required(),
    category: Yup.string()
        .max(30, 'Value must be less than 30')
        .required(),
    purpose: Yup.string()
        .max(30, 'Value must be less than 30')
        .required()
});

export default () => {
    const [notification, setNotification] = useState({isVisible: false, message:'', severity: ''});

    // const onCreateAccount = (account, helpers) => {
    //     createAccount(account)
    //         .then(({status}) => {
    //             if(status === 201) {
    //                 setNotification({isVisible: true, message: 'Account created successfully', severity: 'success'});
    //                 helpers.resetForm();
    //             }
    //         })
    //         .catch((error) => setNotification({isVisible: true, message: 'Something goes wrong', severity: 'error'}))
    //         .finally(() => helpers.setSubmitting(false));
    // }

    return (

        <Formik initialValues={{
            id: '',
            name: '',
            category: '',
            purpose: ''
        }}
//                onSubmit={onCreateAccount}
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
                            <h2>Account creation form:</h2>
                            <TextFieldInput error={props.touched.id && !!props.errors.id}
                                            fieldName="id"
                                            label="Account number:"
                                            placeholder="Type account number..."/>
                            <TextFieldInput error={props.touched.name && !!props.errors.name}
                                            fieldName="name"
                                            label="Account name:"
                                            placeholder="Type account name..."/>
                            <TextFieldInput error={props.touched.category && !!props.errors.category}
                                            fieldName="category"
                                            label="Category:"
                                            placeholder="Type category..."/>
                            <TextFieldInput error={props.touched.purpose && !!props.errors.purpose}
                                            fieldName="purpose"
                                            label="Account type:"
                                            placeholder="Type quantity type..."/>
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