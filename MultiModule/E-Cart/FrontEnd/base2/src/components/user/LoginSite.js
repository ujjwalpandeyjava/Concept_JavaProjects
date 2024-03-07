import '../../assets/style/user.scss';
import React, { Component, ReactPropTypes as PT } from 'react';
import { Grid, Message } from 'semantic-ui-react';
import Scroll from '../scroll/Scroll';
import LoginForm from './LoginForm';
import NewCustomer from './NewCustomer';

const propTypes = {
  handleLogin: PT?.func,
  isLogin: PT?.bool
}

const LoginFormWrap = (props) => (
  <Grid textAlign='center'>
    <Grid.Column width={4} textAlign='left'>
      <LoginForm handleLogin={props.handleLogin} />
    </Grid.Column>
    <Grid.Column width={4} textAlign='left'>
      <NewCustomer />
    </Grid.Column>
  </Grid>
)

const LoginDoneWrap = (props) => (
  <Grid className='login-success' textAlign='center'>
    <Message size='huge' positive>
      <Message.Header>You have successfully logged in.</Message.Header>
      <p>Now you can go to the mall to buy your favorite clothes</p>
    </Message>
  </Grid>
)

class LoginSite extends Component {

  componentDidMount() {
    Scroll(230, 300);
  }

  render() {
    return (
      <div id='login-wrap'>
        {this.props.isLogin ? <LoginDoneWrap /> : <LoginFormWrap isLogin={this.props.isLogin} handleLogin={this.props.handleLogin} />}
      </div>
    )
  }
}

LoginSite.propTypes = propTypes;

export default LoginSite;