import * as React from 'react';
import CssBaseline from '@mui/material/CssBaseline';
import GlobalStyles from '@mui/material/GlobalStyles';
import Container from '@mui/material/Container';
import Account from "../forms/Account";
import Client from "../forms/Client";



export default  () => {
    return (
        <>
            <GlobalStyles styles={{ ul: { margin: 0, padding: 0, listStyle: 'none' } }} />
            <CssBaseline />

            <Container disableGutters maxWidth="sm" component="main" sx={{ pt: 8, pb: 6 }}>
                {/*<Account/>*/}
                <Client/>
            </Container>


        </>
    )
}