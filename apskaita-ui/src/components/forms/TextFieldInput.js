import {ErrorMessage, Field} from "formik";
import {FormControl, FormHelperText, TextField} from "@mui/material";

export default ({fieldName, error, label, placeholder = 'Type here...', ...props}) => (
    <FormControl error={error}
                 variant="outlined"
                 fullWidth
                 margin="dense">
        <Field error={error}
               id={fieldName}
               name={fieldName}
               label={label}
               placeholder={placeholder}
               {...props}
               as={TextField}/>
        <ErrorMessage name={fieldName}
                      component={FormHelperText}/>
    </FormControl>
)
